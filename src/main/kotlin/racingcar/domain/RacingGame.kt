package racingcar.domain

import racingcar.race.RaceResult
import racingcar.race.RoundSnapshot

import racingcar.domain.strategy.MoveStrategy
import racingcar.domain.strategy.RandomMoveStrategy

import racingcar.race.toRoundSnapshot
import racingcar.race.toRaceResult

/**
 * RacingGame manages the simulation of a car race.
 *
 * @property cars List of participating cars (immutable after creation)
 * @property history Stores the result of the last race (access via getHistory())
 */
class RacingGame(private val cars: List<Car>) {

	/**
	 * This method exists only for test code to inspect internal car state
	 * @see moveAllCarsWith
	 * @return Internal list of [Car]s used during race simulation.
	 */
	internal fun getCarsForTesting(): List<Car> = cars

	/* Latest RaceResult, updated after each race() call. */
	private var _history = RaceResult()

	/* Public getter for last recorded race result */
	val history: RaceResult get() = _history

	/**
	 * Runs the race for the given number of rounds.
	 * @param rounds Number of rounds to simulate (must be >= 1, 1-based)
	 * @return Final RaceResult including round-by-round positions and winners
	 */
	fun race(rounds: Int): RaceResult {
		require(rounds >= 1) {
			"Rounds must be at least 1."
		}
		val roundResults = runAllRounds(rounds)
		val result = roundResults.toRaceResult(rounds)
		_history = result
		return result
	}

	/**
	 * Simulates the race over multiple rounds.
	 *
	 * @param rounds Total number of rounds to simulate (1-based)
	 * @return List of RoundSnapshot representing the state after each round
	 */
	private fun runAllRounds(rounds: Int): List<RoundSnapshot> {
		val snapshots = mutableListOf<RoundSnapshot>()
		for (round in 1..rounds) {
			moveAllCars()
			val snapshot = takeRoundSnapshot(round)
			snapshots.add(snapshot)
		}
		return snapshots
	}

	/**
	 * Takes a snapshot of the current state of all cars.
	 *
	 * @param round The current round number (1-based)
	 * @return RoundSnapshot with each car's name and current position
	 */
	private fun takeRoundSnapshot(round: Int): RoundSnapshot {
		return cars.toRoundSnapshot(round)
	}

	/**
	 * Moves all cars one step based on random strategy.
	 * Uses Randoms.pickNumberInRange(0, 9) >= 4 as threshold.
	 */
	private fun moveAllCars() {
		moveAllCarsWith(RandomMoveStrategy())
	}

	fun moveAllCarsWith(strategy: MoveStrategy) {
		cars.forEach { it.moveIf(strategy.shouldMove()) }
	}
}