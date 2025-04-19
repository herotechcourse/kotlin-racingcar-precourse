package racingcar.view

/**
 * Handles displaying race results and winner announcements to the user.
 * Responsible for format and present race data to the user.
 */
object OutputView {
    /**
     * Displays the complete race history showing the progression of all cars.
     * Each round is displayed sequentially with teh position of each car.
     */
    fun displayRace(raceHistory: List<List<Pair<String, Int>>>) {
        println("\nRace Result")
        raceHistory.forEach(::printRound)
    }

    /**
     * Prints a single round of teh race, showing each car's name and progress.
     * Progress is visually represented as a series of dashes.
     */
    private fun printRound(round: List<Pair<String, Int>>) {
        round.forEach { (name, progress) ->
            println("${name} : ${"-".repeat(progress)}")
        }
        println()
    }

    /**
     * Announces the winner(s) of the race.
     * If there are multiple winners, their names are comma separated.
     */
    fun announceWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(", ")
        println("Winners : $winnerNames")
    }
}