package racingcar.util

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.Constants

fun generateRandomNumber(): Int {
    return Randoms.pickNumberInRange(
        Constants.MIN_RANDOM_RANGE,
        Constants.MAX_RANDOM_RANGE
    )
}