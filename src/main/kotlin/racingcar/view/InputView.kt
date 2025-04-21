package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constants.ErrorMessages
import racingcar.constants.InputMessages

object InputView {
    fun getCarNames(): List<String> {
        try {
            println(InputMessages.CAR_NAMES)
            val input: String = Console.readLine()
            val names: List<String> = input.split(',')
            return Validator.validateNames(names)
        } catch (error: IllegalArgumentException) {
            throw error
        }
    }

    fun getRounds(): Int {
        try {
            println(InputMessages.ATTEMPTS)
            val input: String = Console.readLine()
            val rounds: Int = input.toIntOrNull()
                ?: throw IllegalArgumentException(ErrorMessages.Round.INVALID_FORMAT)
            return Validator.validateRounds(rounds)
        } catch (error: IllegalArgumentException) {
            throw error
        }
    }
}