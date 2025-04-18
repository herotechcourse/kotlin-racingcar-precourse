package racingcar.view

object ResultView {
    fun printRoundResult(carResults: List<Pair<String, Int>>) {
        for ((name, position) in carResults) {
            val movement = "-".repeat(position)
            println("$name : $movement")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}