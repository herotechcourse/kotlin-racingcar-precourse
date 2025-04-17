package racingcar.domain.car

import racingcar.domain.RandomNumberGenerator

class Car(
    private val name: Name,
    private var position: Int,
    private val randomNumberGenerator: RandomNumberGenerator
) {
    constructor(name: Name) : this(name, 0, RandomNumberGenerator())

    fun move() {
        if (canMove()) {
            position++
        }
    }

    private fun canMove(): Boolean {
        return randomNumberGenerator.generateNumber() >= MOVEMENT_THRESHOLD
    }

    fun getName(): String {
        return name.name
    }

    fun getPosition(): Int {
        return position
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        private const val MOVEMENT_THRESHOLD: Int = 4
    }
}
