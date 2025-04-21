package racingcar.input

import camp.nextstep.edu.missionutils.Console
import racingcar.util.InputSplitter
import racingcar.validator.InputValidator

object InputReader {
    private fun readIfValidate(prompt: String): String {
        println(prompt)
        val line = Console.readLine()
        InputValidator.isInputEmpty(line)
        return line
    }

    fun readCarNames(prompt: String, max: Int): List<String> {
        val rawInput = readIfValidate(prompt)
        val names = InputSplitter
            .splitByComma(rawInput)
            .map{ it.trim() }

        InputValidator.allNamesAreNotEmpty(names)
        InputValidator.allNamesLessThanMaxLength(names, max)
        return names
    }

    fun readNumberOfRounds(prompt: String): Int {
        val rawInput = readIfValidate(prompt)
        return InputValidator.isNumber(rawInput)
    }
}