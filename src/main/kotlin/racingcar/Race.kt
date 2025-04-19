package racingcar

class Race(
    private val cars: List<Car>,
    private val totalRounds: Int,
    private var currentRound: Int = 1,
    private var winners: List<String>? = null
) {
    fun play() {
        println("\nRace Results")

        while (currentRound <= totalRounds) {
            currentRound++
            cars.forEach {
                it.move()
                it.displayPosition()
            }
            println()
        }

        setWinners()
    }

    private fun setWinners() {
        val maxDistance = cars.maxOf { it.position }
        winners = cars.filter { it.position == maxDistance }.map { it.name }
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