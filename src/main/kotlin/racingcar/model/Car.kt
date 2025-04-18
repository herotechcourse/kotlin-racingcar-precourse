package racingcar.model

/**
 * Represents a car in the racing game.
 * @property name The name of the car must not be blank and at most 5 characters.
 * @property position The current position of the car, defaults to 0.
 */
data class Car(
    val name: String,
    var position: Int = 0
) {

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MOVE_THRESHOLD = 4
    }

    init {
        require(name.isNotBlank()) { "Car name must not be blank." }
        require(name.length <= MAX_NAME_LENGTH) { "Car name must be at most $MAX_NAME_LENGTH characters." }
    }

    /**
     * Moves the car forward by one position if the given random number is 4 or greater.
     * @param randomNumber A number used to determine if the car moves forward.
     */
    fun moveForward(randomNumber: Int) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++
        }
    }

    /**
     * Returns a string representation of the car's progress.
     * The progress is represented by a series of dashes equal to the car's position.
     * @return A string representing the car's progress.
     */
    fun progress(): String = "-".repeat(position)
}
