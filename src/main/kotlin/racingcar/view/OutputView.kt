package racingcar.view

import racingcar.race.RaceResult
import racingcar.race.toDisplayStrings
import racingcar.race.winnerText


/**
 *  singleton object responsible for displaying the race results to the console.
 *  This object takes a [RaceResult] and prints out each round’s progress
 *  along with the final winner(s).
 */
object OutputView {
	/* Prints the entire race progress and the final result to the console. */
	fun printOutput(raceResult: RaceResult) {
		println("\nRace Results")
		raceResult.roundResults
			.flatMap { it.toDisplayStrings() + "" }
			.forEach { println(it) }
		printWinners(raceResult)
	}

	/* Prints the final winner(s) with winnerText() extension to the console. */
	private fun printWinners(result: RaceResult) {
		println(result.winnerText())
	}
}