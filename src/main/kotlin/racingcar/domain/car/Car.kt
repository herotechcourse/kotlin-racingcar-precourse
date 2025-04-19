package racingcar.domain.car

import racingcar.domain.numbergenerator.NumberGenerator
import racingcar.domain.numbergenerator.RandomNumberGenerator

class Car(
    private val name: Name,
    private val position: Position,
    private val numberGenerator: NumberGenerator
) {
    constructor(name: Name) : this(name, Position(), RandomNumberGenerator())

    fun move(): Car {
        if (canMove()) {
            return Car(name, position.increase(), RandomNumberGenerator())
        }
        return this
    }

    private fun canMove(): Boolean {
        return numberGenerator.generate() >= MOVEMENT_THRESHOLD
    }

    fun getName(): String {
        return name.name
    }

    fun getPosition(): Int {
        return position.position
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
