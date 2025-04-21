package racingcar.strategy

/**
 * Strategy interface to determine car movement behavior.
 */
fun interface MovementStrategy {
    fun shouldMove(): Boolean
}
