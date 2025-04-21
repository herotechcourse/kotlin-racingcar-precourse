package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.util.Constant.CAR_MOVEMENT_CONDITION

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= CAR_MOVEMENT_CONDITION) {
            position++
        }
    }
}
