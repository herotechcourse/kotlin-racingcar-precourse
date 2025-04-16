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
}