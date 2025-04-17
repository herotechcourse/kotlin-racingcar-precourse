package racingcar

import camp.nextstep.edu.missionutils.Randoms

object Utils {
  fun getRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
  }
}
