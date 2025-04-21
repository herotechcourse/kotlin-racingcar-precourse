package racingcar.input

import camp.nextstep.edu.missionutils.Console
import racingcar.constants.ErrorMessages
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

    fun getRounds(): Int {
        try {
            println(InputMessages.ATTEMPTS)
            val input = Console.readLine()
            val rounds = input.toIntOrNull()
                ?: throw IllegalArgumentException(ErrorMessages.Round.INVALID_FORMAT)
            return Validator.validateRounds(rounds)
        } catch (error: IllegalArgumentException) {
            throw error
        }
    }
}