package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.InputCarNamesValidator
import racingcar.validator.InputCountValidator

class InputView {
    private val inputCarNamesValidator = InputCarNamesValidator()
    private val inputCountValidator = InputCountValidator()

    fun getInputCarNames(): List<String> {
        println(INPUT_CAR_NAMES_PROMPT)
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }

        inputCarNamesValidator.validate(carNames)
        return carNames
    }

    fun getInputTryCount(): Int {
        println(INPUT_TRY_COUNT_PROMPT)
        val input = Console.readLine()

        inputCountValidator.validate(input)
        return input.toInt()
    }

    companion object {
        private const val INPUT_CAR_NAMES_PROMPT = "Enter the names of the cars (comma-separated):"
        private const val INPUT_TRY_COUNT_PROMPT = "How many rounds will be played?"
    }
}
