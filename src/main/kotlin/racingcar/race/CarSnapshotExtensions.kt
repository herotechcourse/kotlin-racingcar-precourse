package racingcar.race

import racingcar.domain.Car

/**
 * Converts a single Car into a CarSnapshot.
 */
fun Car.toSnapshot(): CarSnapshot {
	return CarSnapshot(
		name = name,
		position = totalDistance()
	)
}

/**
 * Converts a list of Cars into a RoundSnapshot for the given round.
 *
 * @param round The round number (1-based)
 */
fun List<Car>.toRoundSnapshot(round: Int): RoundSnapshot {
	require(round >= 1) {
		"Rounds must be at least 1."
	}
	return RoundSnapshot(
		round = round,
		cars = this.map { it.toSnapshot() }
	)
}
