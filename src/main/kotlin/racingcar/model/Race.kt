package racingcar.model

import racingcar.movement.MovementStrategy

/**
 * Represents an entire race.
 * Manage all cars, the number of rounds, and movement rules (strategy).
 */
class Race(
    private val cars: List<Car>,
    private val totalRounds: Int,
    private val movementStrategy: MovementStrategy
) {
    private var currentRound = 0

    /**
     * Executes one round of the race.
     * Each car is evaluated for movement according to the configured strategy.
     * Throws an exception if the race has already finished.
     */
    fun playRound() {
        require(!isFinished()) { "The race has already finished." }
        cars.map { it.move(movementStrategy.shouldMove()) }
        currentRound++
    }

    /**
     * Returns the current state of all cars in the race.
     */
    fun getCurrentStatus(): List<Car> = cars

    /**
     * Returns true if all configured rounds have been completed.
     */
    fun isFinished(): Boolean = currentRound >= totalRounds

    /**
     * Finds all cars that have reached the maximum distance.
     * @return List of cars with the maximum position.
     */
    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
