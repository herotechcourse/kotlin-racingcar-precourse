package racingcar.validation

import racingcar.movement.CarAdapter

class CarMovementValidator(private val carAdapter: CarAdapter) {

    fun validateCarPosition(expectedPosition: Int): Boolean {
        carAdapter.updatePosition()
        val position = carAdapter.getCar().position
        if (position != expectedPosition) {
            throw IllegalArgumentException("Expected position $expectedPosition, but was $position.")
        }
        return true
    }

    fun validateCarCanMove(): Boolean {
        if (!carAdapter.moveCar()) {
            throw IllegalArgumentException("Car cannot move. Random number was less than 4.")
        }
        return true
    }

    fun validateCarMovement(expectedPosition: Int): Boolean {
        validateCarCanMove()
        return validateCarPosition(expectedPosition)
    }

}
