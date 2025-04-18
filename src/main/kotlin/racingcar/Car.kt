package racingcar

/**
 * Represents a racing car with a name and current position on the track.
 *
 * @property name The name of the car (must be max 5 characters).
 */
class Car(private val name: String) {
    private var position: Int = 0

    /**
     * Moves the car forward by one position if [shouldMove] is true.
     *
     * @param shouldMove A boolean indicating whether the car should move.
     */
    fun move(shouldMove: Boolean) {
        if (shouldMove) {
            position++
        }
    }

    /**
     * Returns the current position of the car.
     *
     * @return The position as an integer.
     */
    fun getPosition(): Int = position

    /**
     * Returns the name of the car.
     *
     * @return The name as a string.
     */
    fun getName(): String = name

    /**
     * Renders the car's race progress in a visual format.
     *
     * Example: "pobi : ---"
     *
     * @return A string representing the car's name and progress.
     */
    fun render(): String {
        return "$name : ${"-".repeat(position)}"
    }
}