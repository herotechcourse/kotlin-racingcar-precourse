package racingcar.io

object OutputPrinter {
    fun printCarPosition(carName: String, position: Int) {
        val movement = "-".repeat(position)
        println("$carName : $movement")
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }

    fun printRoundSeparator() {
        println()
    }
}