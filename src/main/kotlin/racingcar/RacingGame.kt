package racingcar

class RacingGame(private val cars: List<Car>, private val totalRounds: Int) {

    fun start() {
        repeat(totalRounds) {
            cars.forEach { it.move() }
            printRoundResults()
            println()
        }
    }

    private fun printRoundResults() {
        cars.forEach { car ->
            println("${car.name} : ${car.getProgress()}")
        }
    }

    fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}
