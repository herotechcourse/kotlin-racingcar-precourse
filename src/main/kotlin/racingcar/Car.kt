package racingcar

import camp.nextstep.edu.missionutils.Randoms

const val MOVE_THRESHOLD = 4

class Car (val name: String, var pos: Int = 0) {
    private fun rollDice(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun playRound() {
        if (rollDice() >= MOVE_THRESHOLD)
            ++pos
    }
}
