package racingcar.movement

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car

class CarAdapter(private val car: Car, private val randomValue: Int = Randoms.pickNumberInRange(0, 9)) {

    // Function to decide whether the car can move
    private fun shouldMove(): Boolean {
        return randomValue >= 4
    }

    // Function to move the car
    fun moveCar(): Boolean {
        return shouldMove()
    }

    // Function to update the car's position
    fun updatePosition() {
        if (moveCar()) {
            car.position += 1
        }
    }

    // Provide access to the car object
    fun getCar(): Car {
        return car
    }
}
