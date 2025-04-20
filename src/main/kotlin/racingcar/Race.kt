package racingcar

class Race(
    private val cars: List<Car>,
    private val rounds: Int
) {
    fun play() {
        println("\nRace Results")

        repeat(rounds) {
            cars.forEach {
                it.move()
                it.displayPosition()
            }
            println()
        }
    }

    fun getWinners(): List<String> {
        val maxDistance = cars.maxOf { it.getDistance() }
        return cars.filter { it.getDistance() == maxDistance }.map { it.name }
    }

    fun displayWinners() {
        val winners = getWinners()
        print("Winners : ")
        println(winners.joinToString(", "))
    }
}