package racingcar

// Import the Randoms utility for generating random numbers
import camp.nextstep.edu.missionutils.Randoms

// Car class - represent each car in the race
class Car(val name: String, var position: Int = 0) {

    // Validate that the car name is not empty and does not exceed 5 characters
    init{
        require(name.isNotEmpty() && name.length <= 5) {
            "Car name must be between 1 and 5 characters."
        }
    }

    // Move the car forward by 1 if a random number between 0 and 9 (inclusive) is greater than or equal to 4
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    // Check if the car is at the given position
    fun isAt(position: Int): Boolean = this.position == position

}