package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constants.MessageConstants
import racingcar.util.CarNameValidator
import racingcar.util.NumberValidator
import racingcar.util.StringUtil

object InputView {

    fun readCarNames(): List<String> {
        println(MessageConstants.INPUT_CAR_NAME)
        val input = Console.readLine()
        val names = StringUtil.convertToList(input)
        return CarNameValidator(names).validate()
    }

    fun readRoundCount(): Int {
        println(MessageConstants.INPUT_ROUND_COUNT)
        val input = Console.readLine()
        return NumberValidator(input).validate()
    }
}