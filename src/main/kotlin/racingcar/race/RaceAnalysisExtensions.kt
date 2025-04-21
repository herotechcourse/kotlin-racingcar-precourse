package racingcar.race

/**
 * Returns the maximum distance reached by any car in the current race.
 * @return Maximum distance traveled by any car
 */
fun List<RoundSnapshot>.leadingDistance(): Int {
	return this.last().cars.maxOf { it.position }
}

/**
 * Returns names of all cars at the leading position in the race.
 * @return List of winner names (can be multiple in case of a tie)
 */
fun List<RoundSnapshot>.winnerNames(): List<String> {
	val max = this.leadingDistance()
	return this.last().cars.filter { it.position == max }
		.map { it.name }
}

/**
 * Converts a list of round snapshots into a final race result.
 *
 * @param rounds Total number of rounds in the race
 * @return Complete race result with winners and statistics
 */
fun List<RoundSnapshot>.toRaceResult(rounds: Int): RaceResult {
	val leadingDistance = this.leadingDistance()
	val winners = this.winnerNames()

	return RaceResult(
		totalRounds = rounds,
		raceWinners = winners,
		roundResults = this,
		leadingDistance = leadingDistance
	)
}
