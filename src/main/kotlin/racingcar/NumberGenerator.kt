package racingcar
import camp.nextstep.edu.missionutils.Randoms


fun interface NumberGenerator {
    fun generate(): Int
}

class DefaultNumberGenerator : NumberGenerator {
    override fun generate(): Int = Randoms.pickNumberInRange(0, 9)
}





