package racingcar

import racingcar.generator.RandomNumberGenerator

class Car(val name: String) {

    var position = 0
        private set

    companion object {
        const val MAX_NAME_LENGTH = 5
        const val MOVE_THRESHOLD = 4
    }

    init{
        if(name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("Car name must have at least 5 characters")
        }
    }

    fun move(randomGenerator: RandomNumberGenerator) {
        if (randomGenerator.generate() >= MOVE_THRESHOLD) {
            position++
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (position != other.position) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = position
        result = 31 * result + name.hashCode()
        return result
    }


}