package racingcar.movement

/**
 * Strategy interface for determining whether a car should move.
 * Actual movement direction or logic is decided by its implementation.
 */
interface MovementStrategy {
    fun shouldMove(): Boolean
}
