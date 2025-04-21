package racingcar.domain

import racingcar.utils.Number.POSSIBLE_MOVE_VALUE

class Car(
    private val name: String,
    private var position: Int = 0
) {
    fun getPosition(): Int = position

    fun getName(): String = name

    fun movePosition(randomValue: Int) {
        if (isMovable(randomValue)) {
            position++
        }
    }

    private fun isMovable(randomValue: Int): Boolean {
        return randomValue >= POSSIBLE_MOVE_VALUE
    }
}