package racingcar.strategy

fun interface MoveStrategy {
    fun shouldMove(): Boolean
}