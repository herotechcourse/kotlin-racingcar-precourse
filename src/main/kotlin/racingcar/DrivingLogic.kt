package racingcar
import camp.nextstep.edu.missionutils.Randoms

fun getRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}