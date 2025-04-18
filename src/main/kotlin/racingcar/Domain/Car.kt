package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car in the racing game.
 *
 * @property name The name of the car (must not exceed 5 characters)
 * @property position The current position of the car (0-based)
 */
class Car(val name: String) {
    init {
        validateName(name)
    }

    var position: Int = 0
        private set

    /**
     * Attempts to move the car forward based on a random number.
     * The car moves if the random number is 4 or greater.
     */
    fun move() {
        if (shouldMove()) {
            position++
        }
    }

    /**
     * Determines whether the car should move forward based on a random number.
     *
     * @return true if the car should move, false otherwise
     */
    private fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD_THRESHOLD
    }

    /**
     * Gets the position of the car as a string of dashes.
     *
     * @return A string of dashes representing the car's position
     */
    fun getPositionDisplay(): String {
        return "-".repeat(position)
    }

    private fun validateName(name: String) {
        require(name.length <= MAX_NAME_LENGTH) {
            "Car name cannot exceed $MAX_NAME_LENGTH characters: '$name'"
        }
        require(name.isNotBlank()) { "Car name cannot be blank." }
        require(!name.contains(",")) {
            "Car name cannot contain commas: '$name'"
        }
        require(!INVALID_CHARACTERS.any { it in name }) {
            "Car name contains invalid characters: '$name'"
        }
    }

    companion object {
        private const val MOVING_FORWARD_THRESHOLD = 4
        private const val MAX_NAME_LENGTH = 5
        private val INVALID_CHARACTERS = setOf(' ', '\t', '\n', '\r')
    }
}
