package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.Number.RANDOM_MAX_VALUE
import racingcar.utils.Number.RANDOM_MIN_VALUE

object RandomNumberGenerator {
    fun generateRandom() : Int{
        return Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE)
    }
}