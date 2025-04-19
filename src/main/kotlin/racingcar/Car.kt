package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
    var position: Int = 0
) {
    fun move() {
        if (canMove()) position++
    }

    fun displayPosition() {
        val dashes = "-".repeat(position)
        println("$name : $dashes")
    }

    private fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}