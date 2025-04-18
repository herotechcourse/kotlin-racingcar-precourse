package racingcar.reader

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.RacingValidator

class InputParamsReader {
    private val validator = RacingValidator()

    fun retrieveCarNames(): List<String> {
        val carNamesInput = Console.readLine()
        val carNames = carNamesInput.split(",").filter { it.trim().isNotEmpty() }.map { it.trim() }

        if (carNames.isEmpty()) {
            throw IllegalArgumentException("No cars were added")
        }

        validator.validateCarNames(carNames)
        return carNames
    }

    fun retrieveRoundsAmount(): Int {
        val amount = Console.readLine()
        try {
            val rounds = amount.toInt()
            if (rounds < 1) {
                throw IllegalArgumentException("Number of rounds can't be less than 1")
            }
            return rounds
        } catch (exception: NumberFormatException) {
            throw IllegalArgumentException("Invalid input round number")
        }
    }
}