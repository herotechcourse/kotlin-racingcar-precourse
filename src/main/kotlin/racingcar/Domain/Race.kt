package racingcar.domain

/**
 * Represents a car racing game.
 *
 * @property cars List of cars participating in the race
 * @property rounds Number of rounds to be played
 */
class Race(val cars: List<Car>, val rounds: Int) {
    init {
        validateRaceParameters(cars, rounds)
    }

    /**
     * Executes a single round of the race, moving each car.
     */
    fun executeRound() {
        cars.forEach { it.move() }
    }

    /**
     * Finds the winner(s) of the race.
     * A winner is a car that has advanced the furthest after all rounds.
     * There can be multiple winners if they have the same position.
     *
     * @return List of cars that are winners
     */
    fun findWinners(): List<Car> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.position == maxPosition }
    }

    /**
     * Finds the maximum position reached by any car in the race.
     *
     * @return The maximum position
     */
    private fun findMaxPosition(): Int {
        return cars.maxOfOrNull { it.position } ?: 0
    }

    private fun validateRaceParameters(cars: List<Car>, rounds: Int) {
        require(cars.isNotEmpty()) { "At least one car is required for the race." }
        require(rounds > 0) { "Number of rounds must be positive." }
    }
}