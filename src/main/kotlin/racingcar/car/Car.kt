package racingcar.car

import racingcar.strategy.MoveStrategy

data class Car(
    val name: String,
    private var position: Int = 0
) {
    fun move(strategy: MoveStrategy) {
        if (strategy.canMove()) position++
    }

    fun position() = position
}
