package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

/**
* Represents a car in the race
* @param name The car's name
* @throws IllegalArgumentException if name is empty or exceeds 5 charachters
 */
data class Car(val name:String) {

    init {
        validateName(name)
    }

    private var position = 0

    /**
    * Validates that the car name meets requirements
     */
    private fun validateName(name: String) {
        if (name.isEmpty()){
            throw IllegalArgumentException("Car name cannot be empty")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters: $name")
        }
    }

    /**
    * Moves the car forward if the random number is 4 or greater
     */
    fun moveForward() {
        if (shouldMove()) {
            position++
        }
    }

    /**
    * Determines if the car should move based on random number
    * @return true if car should move, false otherwise
     */

    private fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0,9) >= 4
    }

    /**
    * Gets the current position of the car
    * @return current position
     */
    fun getPosition(): Int{
        return position
    }
}
