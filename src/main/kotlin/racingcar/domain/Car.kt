package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car (
    val name: String,
    val currentProgress: Int = 0,
){
    fun printProgress() {
        println(name + " : " + "-".repeat(currentProgress))
    }

    fun forwardCar(): Car {
        if (canForward()) {
            return Car(name, currentProgress + 1)
        } else {
            return this
        }
    }

    private fun canForward(): Boolean {
        return if (Randoms.pickNumberInRange(0, 9) >= 4) true else false
    }
}