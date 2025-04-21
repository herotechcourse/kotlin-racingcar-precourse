package racingcar.domain

/**
 * Represents a car participating in the race.
 *
 * @property name the identifier of the car (must be validated externally)
 * @property moves immutable view of movement history per round
 *     - Index = `round number - 1` (0-based index for 1-based round)
 *     - Value = moved distance in that round (0 or 1)
 *
 * The car moves forward only when `moveIf(true)` is called,
 * recording either 1 (moved) or 0 (stayed) in the history.
 *   - The current position is the sum of all moves.
 *   - A partial position (up to a round) can be queried for logging or testing.
 */
class Car(val name: String) {

	/**
	 * Validates car name length on creation (1~5 characters allowed)
	 * @throws IllegalArgumentException if condition is not satisfied.
 	 */
	init {
		require(name.length in 1..5) {
			"The car name must be at least 1 character and no more than 5 characters. Input value: '$name'"
		}
	}

	/** Mutable movement history, where each element is 0 (stayed) or 1 (moved) */
	private val _moves = mutableListOf<Int>()
	/** Immutable view of car movement history per round */
	val         moves: List<Int> get() = _moves.toList()

	/**
	 * Records movement for this round.
	 * Adds 1 if moved, or 0 if stayed.
	 */
	fun moveIf(shouldMove: Boolean) {
		if (shouldMove) _moves.add(1) else _moves.add(0)
	}

	/**
	 * Checks if the car moved in the specified round.
	 * @param round index of the round (1-based)
	 */
	fun didMoveAt(round: Int): Boolean {
		require(round in 1.. moves.size) {
			"Round must be between 1 and ${moves.size} (inclusive)"
		}
		val index = round - 1
		return _moves[index] == 1
	}

	/**
	 * @return true if the car has moved at least once.
	 */
	fun hasMove(): Boolean {
		return _moves.any { it == 1 }
	}

	/**
	 * @return the total distance moved (sum of all movements).
	 */
	fun totalDistance(): Int {
		return _moves.sum()
	}

	/**
	 * For example:
	 * - round = 1 → includes only round 1 (index 0)
	 * - round = 2 → includes rounds 1 and 2 (indexes 0 and 1)
	 *
	 * @param round 1-based round number (must be in 1..moves.size)
	 * @return The cumulative distance moved up to and including the specified round
	 * @throws IllegalArgumentException if round is out of bounds
	 */
	fun distanceUntil(round: Int): Int {
		require(round in 1..moves.size) {
			"Round must be between 1 and ${moves.size} (inclusive)"
		}
		return _moves.take(round).sum()
	}
}