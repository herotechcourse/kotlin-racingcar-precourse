package racingcar

import camp.nextstep.edu.missionutils.Randoms

class CAr(val name: String) {
    var position = 0

    if (shouldMove()){
        position++
    }

    private fun shouldMove(): Boolean {
        return camp.nextstep.edu.missionutils.Randoms(0, 9) >= 4
    }

    fun getPositionDisplay(): String {
        return "-".repeat(position)
    }
}