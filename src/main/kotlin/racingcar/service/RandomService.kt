package racingcar.service
import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Constants

class RandomService {
    fun generateMoveValue(): Int {
        return Randoms.pickNumberInRange(Constants.RANDOM_MIN, Constants.RANDOM_MAX)
    }
}