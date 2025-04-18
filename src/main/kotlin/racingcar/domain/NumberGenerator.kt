package racingcar.domain
import camp.nextstep.edu.missionutils.Randoms

object NumberGenerator {
    fun createRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}