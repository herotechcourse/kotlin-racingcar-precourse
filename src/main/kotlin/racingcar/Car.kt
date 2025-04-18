package racingcar

import camp.nextstep.edu.missionutils.Randoms

const val MOVE_THRESHOLD: Int = 4
const val PROGRESS_BAR: String = "-"

class Car (val name: String, var pos: Int = 0) {
    private fun rollDice(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun getCarInfo(): Pair<String, Int> {
        return Pair(name, pos)
    }

    fun playRound() {
        if (rollDice() >= MOVE_THRESHOLD)
            ++pos
    }
}
