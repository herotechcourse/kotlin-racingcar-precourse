package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RacingCar (
    val name : String,
    var pos: Int = 0
) {
    fun run() {
        val randomNumber = generateNumber()
        moveForward(randomNumber)
    }

    private fun generateNumber() : Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun moveForward(number : Int) {
        if (number >= 4)
            pos++;
    }

}
