package racingcar

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car in the racing game.
 * Stores the car's name and current position.
 * The car can move forward if a random condition is met.
 *
 * @property name The name of the car (maximum 5 characters).
 * @property position The current position of the car on the track.
 */
class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Car name must be non-empty and at most 5 characters."
        }
    }
}


