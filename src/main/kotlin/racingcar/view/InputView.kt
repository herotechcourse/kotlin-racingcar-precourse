package racingcar.view

import racingcar.util.Constant.CAR_NAME_DELIMITER
import racingcar.util.Constant.CAR_NAME_MESSAGE

class InputView {
    fun inputCarNames(): List<String> {
        println(CAR_NAME_MESSAGE)
        return readln().split(CAR_NAME_DELIMITER).map { it.trim() }
    }
}