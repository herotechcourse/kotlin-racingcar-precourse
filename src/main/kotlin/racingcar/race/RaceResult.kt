package racingcar.race

/**
 * Aggregated result of a completed race.
 *
 * This is the final summary returned after all rounds are completed.
 * It includes metadata (number of rounds), winner(s), and round-by-round snapshots.
 *
 * @property totalRounds Number of rounds the race was run (must be ≥ 1).
 * @property raceWinners Names of cars that reached the furthest distance.
 * @property roundResults A list of snapshots, one for each round.
 */
data class RaceResult(
	val totalRounds: Int = 0,
	val raceWinners: List<String> = emptyList(),
	val roundResults: List<RoundSnapshot> = emptyList(),
	val leadingDistance: Int = 0
)

/**
 * Represents the complete state of all cars at the end of a specific round.
 *
 * This is used to track the progression of the race.
 * Round numbering is 1-based (i.e., round 1 is the first round).
 *
 * @property round Round number (starts at 1).
 * @property cars List of car states at this round (see [CarSnapshot]).
 */
data class RoundSnapshot(
	val round: Int,
	val cars: List<CarSnapshot>
)

/**
 * Represents a car’s state (name and position) at a specific round.
 *
 * This is a simple view object used within a round snapshot.
 * It does **not** track historical position or winner status —
 * that information is stored in [RaceResult].
 *
 * @property name Unique identifier of the car.
 * @property position Distance the car has reached by the end of the round.
 */
data class CarSnapshot(
	val name: String,
	val position: Int
)