package racingcar.input

import camp.nextstep.edu.missionutils.Console
import racingcar.constants.InputMessages

object InputView {
    fun getCarNames(): List<String> {
        try {
            println(InputMessages.CAR_NAMES)
            val names: List<String> = Console.readLine().split(',')
            return Validator.validateNames(names)
        } catch (error: IllegalArgumentException) {
            throw error
        }
    }
}