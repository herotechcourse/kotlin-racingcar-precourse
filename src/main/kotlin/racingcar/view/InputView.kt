package racingcar.view

import racingcar.util.Constant.CAR_NAME_DELIMITER
import racingcar.util.Constant.CAR_NAME_MESSAGE
import racingcar.util.Constant.ROUND_COUNT_MESSAGE
import racingcar.util.Exceptions.validateInteger
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputCarNames(): List<String> {
        println(CAR_NAME_MESSAGE)
        return Console.readLine().split(CAR_NAME_DELIMITER).map { it.trim() }
    }

    fun inputRoundCount(): Int {
        println(ROUND_COUNT_MESSAGE)
        return Console.readLine().also { it.validateInteger() }.toInt()
    }
}