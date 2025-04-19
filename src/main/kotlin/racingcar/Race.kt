package racingcar

class Race(
    private val cars: List<Car>,
    private val totalRounds: Int,
    private var currentRound: Int = 0,
    private var winners: List<String>? = null
) {
    fun play() {
        println("\nRace Results")

        while (currentRound <= totalRounds) {
            currentRound++
            cars.forEach { car ->
                car.move()
                displayRound(car)
            }
            println()
        }

        setWinners()
    }

    private fun setWinners() {
        val maxDistance = cars.maxOf { it.distance }
        winners = cars.filter { it.distance == maxDistance }.map { it.name }
    }

    private fun displayRound(car: Car) { // TODO move this method to class Car
        val dashes = "-".repeat(car.distance)
        println(car.name + " : " + dashes)
    }

    fun displayWinners() {
        if (winners == null) return

        print("Winners : ")
        winners!!.forEachIndexed { index, winner ->
            print(winner)
            if (index != winners!!.size - 1) print(", ")
        }
    }
}