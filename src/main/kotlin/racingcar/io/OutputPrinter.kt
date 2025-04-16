package racingcar.io

const val MOVEMENT_SYMBOL = "-"

object OutputPrinter {
    fun printCarPosition(carName: String, position: Int) {
        val movement = MOVEMENT_SYMBOL.repeat(position)
        println("$carName : $movement")
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }

    fun printRoundSeparator() {
        println()
    }
}