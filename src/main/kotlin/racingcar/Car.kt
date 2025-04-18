package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car in the racing game.
 *
 * @property name the name of the car
 * @property movement the number of moves the car has made
 */
class Car(val name: String) {
    var movement = 0

    /**
     * Moves the car forward if a randomly generated number between 0 and 9 is 4 or greater.
     * This simulates the car's ability to move based on chance.
     */
    fun moveIfPossible() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            movement++;
        }
    }
}