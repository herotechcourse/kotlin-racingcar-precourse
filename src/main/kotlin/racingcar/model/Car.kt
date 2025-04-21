package racingcar.model

/**
 * Represents a racing car.
 * Each car has an immutable name and a mutable position.
 */
class Car(
    private val _name: String,
    private var _position: Int = 0
) {
    val name: String
        get() = _name
    val position: Int
        get() = _position

    // Validates that the car name is not blank and does not exceed 5 characters.
    init {
        require(name.isNotBlank()) { "Car name must not be blank." }
        require(name.length <= 5) { "Car name cannot exceed 5 characters." }
    }

    /**
     * Moves the car forward by one if the shouldMove evaluation returns true.
     * @param shouldMove Whether the car is allowed to move forward.
     */
    fun move(shouldMove: Boolean) {
        if (shouldMove) _position++;
    }

    /**
     * Returns a formatted string representing the car's name and position.
     */
    override fun toString(): String = "$name : ${"-".repeat(position)}"
}
