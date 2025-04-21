package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object Generator {

    fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}