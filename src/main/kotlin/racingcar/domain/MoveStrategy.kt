package racingcar.domain

interface MoveStrategy {
    fun isMovable(car: Car): Boolean
}