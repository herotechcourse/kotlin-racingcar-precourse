package racingcar

/**
 * Represents a car in the racing game.
 *
 * @property name the name of the car
 * @property movement the number of moves the car has made
 * @property randomNumberGenerator function that returns a random number (used for movement decision)
 */
class Car(
    val name: String,
    private val randomNumberGenerator: () -> Int = { camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9) }
) {
    var movement = 0

    /**
     * Moves the car forward if a generated number is 4 or greater.
     * This simulates the car's ability to move based on chance.
     */
    fun moveIfPossible() {
        if (randomNumberGenerator() >= 4) {
            movement++
        }
    }
}