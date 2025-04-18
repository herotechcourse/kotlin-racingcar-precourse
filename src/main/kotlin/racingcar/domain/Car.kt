package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, rounds: Int) {
    val moveHistory= BooleanArray(rounds) {false}

    fun progress(round: Int) {
        if (canMove()) {
            moveHistory[round] = true
        }
    }

    private fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}