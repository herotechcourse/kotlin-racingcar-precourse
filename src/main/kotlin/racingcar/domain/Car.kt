package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

// Car represents a racing participant with injectable randomness for testability.
class Car (
    private val name: String,
    private val randomProvider: () -> Int = {Randoms.pickNumberInRange (RANDOM_MIN,RANDOM_MAX)}
) {
    init {
        require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) { "Car name '$name' must be  maximum $MAX_NAME_LENGTH characters" }
    }

    private var position = 0
    fun getPosition(): Int = position
    fun getName(): String = name


    fun move() {
        if (randomProvider() >= ADVANCE_LIMIT) {
            position++
        }
    }

        override fun toString(): String = "$name : ${"-".repeat(position)}"

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val RANDOM_MIN = 0
        private const val RANDOM_MAX = 9
        private const val ADVANCE_LIMIT = 4  // minimum random value required for a car to advance

    }
}
