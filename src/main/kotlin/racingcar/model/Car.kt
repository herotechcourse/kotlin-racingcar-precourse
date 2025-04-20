package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car participating in the racing game.
 *
 * @property name The name of the car (must not be blank, and max 5 characters).
 */
class Car(val name: String){
    init {
        require(name.isNotBlank()){"Car name cannot be Blank"}
        require(name.length<=5){"Car name cannot exceed 5 characters"}
    }

    // Car's current position on the track (starting at 0)
    private  var position = 0

    /**
     * Moves the car forward by 1 if a random number between 0 and 9 is 4 or greater.
     */
    fun move(){
        if (Randoms.pickNumberInRange(0,9)>=4){
            position++
        }
    }

    /**
     * Returns the current position of the car.
     *
     * @return the position as an integer.
     */
    fun getPosition():Int = position
}
