package racingcar.view

object OutputView {
    fun printProgress(progress: List<List<String>>) {
        println("\nRace Results")
        progress.forEach { round ->
            round.forEach { println(it) }
            println()
        }
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}