package racingcar

object OutputView {

    fun printRoundResultHeader() {
        println("\nRace Results")
    }

    fun printRoundStatus(cars: List<Car>) {
        cars.forEach { println(it) }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}
