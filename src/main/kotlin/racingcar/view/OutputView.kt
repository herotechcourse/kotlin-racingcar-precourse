package racingcar.view

object OutputView {
    fun displayRace(raceHistory: List<List<Pair<String, Int>>>) {
        println("\nRace Result")
        raceHistory.forEach(::printRound)
    }

    private fun printRound(round: List<Pair<String, Int>>) {
        round.forEach { (name, progress) ->
            println("${name} : ${"-".repeat(progress)}")
        }
        println()
    }

    fun announceWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(", ")
        println("Winners : $winnerNames")
    }
}