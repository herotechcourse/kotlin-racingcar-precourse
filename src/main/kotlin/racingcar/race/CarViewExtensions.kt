package racingcar.race

/**
 * @return a displayable progress bar string.
 * Format: "name : ----" where "-" represents the position.
 */
fun CarSnapshot.toProgressBar(): String {
	return "$name : ${"-".repeat(position)}"
}

/**
 * @return a list of car progress bars for a round.
 * Each entry is generated using CarSnapshot.toProgressBar().
 */
fun RoundSnapshot.toDisplayStrings(): List<String> {
	return cars.map { it.toProgressBar() }
}

/**
 * @return a formatted string listing the race winners.
 * Format: "Winners : pobi, jun"
 *         "Winners : pobi"
 */
fun RaceResult.winnerText(): String {
	return "Winners : ${raceWinners.joinToString(", ")}"
}