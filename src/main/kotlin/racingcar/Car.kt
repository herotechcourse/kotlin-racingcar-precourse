package racingcar

/**
 * Represents a car in the racing game.
 *
 * @property name the name of the car, which must be non-blank and up to 5 characters long
 * @throws IllegalArgumentException if the name is blank or exceeds 5 characters
 */
class Car(val name: String) {
    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Car name cannot be blank.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name '$name' should not exceed 5 characters.")
        }
    }
}