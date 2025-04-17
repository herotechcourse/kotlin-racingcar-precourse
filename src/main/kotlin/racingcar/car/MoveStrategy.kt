package racingcar.car

interface MoveStrategy {
    fun shouldMove(): Boolean
}