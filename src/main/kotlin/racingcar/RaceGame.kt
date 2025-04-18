package racingcar

class RaceGame(
    private val names: List<String>,
    private val rounds: Int
) {
    private val cars = names.map { Car(it) }

    fun start() {
        println("\nRace Results")

        repeat(rounds) {
            cars.forEach { it.move() }
            cars.forEach { it.printStatus() }
            println()
        }

        printWinners()
    }

    private fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }
            .joinToString(", ") { it.name }

        println("Winners : $winners")
    }
}
