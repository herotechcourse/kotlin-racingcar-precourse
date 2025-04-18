package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

fun decideMovement(): Boolean {
    val randomNumber = Randoms.pickNumberInRange(0, 9)

    return randomNumber >= 4
}