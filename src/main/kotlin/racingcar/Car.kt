package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
    private var distance: Int = 0
) {
    fun move() {
        if (canMove()) distance++
    }

    fun getDistance() = distance

    fun displayPosition() {
        println("$name : ${"-".repeat(distance)}")
    }

    private fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}