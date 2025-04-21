package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

fun decideProgress(): Boolean {
    val randomNumber = Randoms.pickNumberInRange(0, 9)

    return randomNumber >= 4
}