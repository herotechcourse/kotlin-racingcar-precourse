package racingcar.domain

import racingcar.util.ExceptionMessage

class Car (
    val name: String,
    val currentProgress: Int = 0,
){
    fun printProgress() {
        println(name + " : " + "-".repeat(currentProgress))
    }

    fun forwardCar(moveCondition: Int): Car {
        validateCondition(moveCondition)
        if (canForward(moveCondition)) {
            return Car(name, currentProgress + 1)
        } else {
            return this
        }
    }

    private fun canForward(moveCondition: Int): Boolean {
        return if (moveCondition >= 4) true else false
    }

    private fun validateCondition(moveCondition: Int) {
       if (moveCondition < 0 || moveCondition > 9) {
           throw IllegalArgumentException(ExceptionMessage.INVALID_MOVE_CONDITION.message)
       }
    }
}