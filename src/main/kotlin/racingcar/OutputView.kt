package racingcar

object OutputView {

    fun printRaceStart() {
        println("\nRace Results")
    }

    fun printRound(cars: Cars) {
        cars.printRound()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}