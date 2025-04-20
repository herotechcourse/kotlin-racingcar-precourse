package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.exception.ExceptionMessage
import racingcar.model.Constants
import racingcar.service.InputValidator

object InputView {
    fun getCarNames(): List<String>{
        println("Enter the names of the cars(comma-separated):")
        val input = Console.readLine()
        val carNames = input.split(Constants.CAR_NAME_DELIMITER).map{it.trim()}
        InputValidator.validateCarNames(carNames)
        return carNames
    }

    fun getRoundCounts(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val rounds = try {
            input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }
        InputValidator.validateRounds(rounds)
        return rounds
    }
}