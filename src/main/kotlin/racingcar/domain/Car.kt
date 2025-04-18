package racingcar.domain

/**
 * Represents a car in the racing game
 * @property name The name of the car
 */
class Car(val name: String) {
    private var position = 0

    /**
     * Decides whether to move forward based on random number
     * @param randomNumber The random number
     */
    fun move(randomNumber: Int) {
        if (randomNumber >= FORWARD_THRESHOLD) {
            position++
        }
    }

    /**
     * Gets current position
     * @return The current position
     */
    fun getPosition(): Int {
        return position
    }

    companion object {
        private const val FORWARD_THRESHOLD = 4
    }
} 