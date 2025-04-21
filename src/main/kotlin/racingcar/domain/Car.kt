package racingcar.domain

import racingcar.utils.Number.POSSIBLE_MOVE_VALUE

class Car(
    private val name: String,
    private var position: Int = 0,
    private val id: Int
) {
    fun getPosition(): Int = position

    fun getName(): String = name

    fun getId(): Int = id

    fun movePosition(randomValue: Int) {
        if (isMovable(randomValue)) {
            position++
        }
    }

    private fun isMovable(randomValue: Int): Boolean {
        return randomValue >= POSSIBLE_MOVE_VALUE
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false
        return this.id == other.id
    }

    override fun hashCode(): Int {
        return id
    }
}