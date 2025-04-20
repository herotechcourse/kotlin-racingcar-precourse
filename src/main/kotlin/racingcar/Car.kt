package racingcar

/**
 * Represents a racing car in the game.
 *
 * Each car has a [name] and a current [position] on the track.
 * The car can move forward based on game logic and prints its current
 * position as a series of dashes (`-`) based on how far it has moved.
 *
 * @property name The name of the car. Must be non-blank and at most 5 characters.
 * @throws IllegalArgumentException if the name is invalid.
 */
class Car (val name: String) {
    init {
        require(name.isNotBlank()) { "Car name must not be blank." }
        require(name.length <= 5) { "Car name must be 5 characters or fewer." }
    }

    /**
     * The current position of the car, starting from 0.
     */
    var position: Int = 0
        private set

    /**
     * Moves the car forward by one position.
     * Typically called when a random number meets the movement criteria.
     */
    fun move() {
        position++
    }


    /**
     * Returns the car's current status as a formatted string,
     * combining its name and movement using dashes.
     *
     * Example: "pobi : ---"
     */
    override fun toString(): String {
        return "$name : ${"-".repeat(position)}"
    }
}