package racingcar.reader

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.RacingValidator

class InputParamsReader {
    private val validator = RacingValidator()

    fun retrieveCarNames(): List<String> {
        val carNamesInput = Console.readLine()
        val carNames = carNamesInput.split(",").map { it.trim() }
        validator.validateCarNames(carNames)
        return carNames
    }

    fun retrieveRoundsAmount(): Int {
        val amount = Console.readLine()
        try {
            return amount.toInt()
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("Invalid input round number")
        }
    }
}