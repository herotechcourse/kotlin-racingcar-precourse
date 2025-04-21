package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car (
    val name: String,
    val currentProgress: Int = 0,
){
    fun printProgress() {
        println(name + " : " + "-".repeat(currentProgress))
    }

    fun forwardCar(moveCondition: Int): Car {
        if (canForward(moveCondition)) {
            return Car(name, currentProgress + 1)
        } else {
            return this
        }
    }

    private fun canForward(moveCondition: Int): Boolean {
        return if (moveCondition >= 4) true else false
    }
}