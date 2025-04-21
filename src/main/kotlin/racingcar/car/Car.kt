package racingcar.car

import racingcar.constants.Constants

class Car(val name: String) {
    var position: Int = 0
        private set

    private fun moveForward() {
        position++
    }

    fun tryMoveForward(randomNumber: Int) {
        if (randomNumber >= Constants.MIN_RANDOM_TO_MOVE) {
            moveForward()
        }
    }
}