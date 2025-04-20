package racingcar.model

import racingcar.util.Constant.CAR_NAME_CANNOT_BLANK_ERROR_MESSAGE
import racingcar.util.Constant.CAR_NAME_EXCEED_ERROR_MESSAGE
import racingcar.util.Constant.MAX_CAR_NAME_SIZE

class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.length <= MAX_CAR_NAME_SIZE) { CAR_NAME_EXCEED_ERROR_MESSAGE }
        require(name.isNotBlank()) { CAR_NAME_CANNOT_BLANK_ERROR_MESSAGE }
    }
}
