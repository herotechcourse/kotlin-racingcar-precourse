package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * This class represents a car in the racing game.
 */
class Car(val name: String) {
    private var position = 0

    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Car name must be non-empty and up to 5 characters."
        }
    }

    /**
     * This method is responsible for attempting to move the car forward.
     * The car moves forward by 1 position if a randomly generated number between 0 and 9 is 4 or greater.
     */
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    /**
     * This method is responsible for returning the current position of the car.
     *
     * @return the number of moves the car has made.
     */
    fun getPosition(): Int = position

    /**
     * This method is responsible for returning a visual representation of the car's current position.
     *
     * @return A string in the format "name : ---".
     */
    fun display(): String = "$name : ${"-".repeat(position)}"
}
