package racingcar.strategy.move

fun interface MoveStrategy {
    fun shouldMove(): Boolean
}