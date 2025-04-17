package racingcar

class Race(private val cars: List<Car>, private val rounds: Int) {

    fun start() {
        println("Race Results")
        repeat(rounds) {
            cars.forEach { it.tryMove() }
            printRaceStatus()
        }
        printWinners()
    }

    private fun printRaceStatus() {
        cars.forEach { println(it.displayStatus()) }
        println()
    }

    private fun printWinners() {
        val max = cars.maxOfOrNull { it.progress }
        val winners = cars.filter { it.progress == max }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}
