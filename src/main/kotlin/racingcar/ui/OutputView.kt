package racingcar.ui

class OutputView {
    fun printRaceResults(cars: List<racingcar.domain.Car>) {
        println("\nRace Results")
        cars.forEach { println(it) }
        println()
    }

    fun printWinners(winners: List<racingcar.domain.Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}