package racingcar.domain

class Race(private val cars: List<Car>, private val numberOfRounds: Int) {

    fun start() {
        println("Race Results")
        repeat(numberOfRounds) {
            moveCars()
            printStatus()
            println()
        }
        printWinners()
    }

    private fun moveCars() {
        cars.forEach { it.move() }
    }

    private fun printStatus() {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionRepresentation()}")
        }
    }

    private fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}