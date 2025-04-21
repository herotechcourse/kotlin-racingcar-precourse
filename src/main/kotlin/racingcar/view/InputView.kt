package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.StringParser

class InputView {

    fun readCarNames(): List<String> {
        println(READ_CAR_NAMES_MESSAGE)
        val carNames = readInput()
        return StringParser.parseByDelimiter(carNames, CAR_NAME_DELIMITER)
    }

    fun readTotalRounds(): Int {
        println(READ_TOTAL_ROUNDS_MESSAGE)
        val input = readInput()
        return StringParser.parseToInt(input)
    }

    private fun readInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }

    companion object {
        private const val READ_CAR_NAMES_MESSAGE = "Enter the names of the cars (comma-separated):"
        private const val READ_TOTAL_ROUNDS_MESSAGE = "How many rounds will be played?"

        private const val CAR_NAME_DELIMITER = ","

        private const val INVALID_INPUT_ERROR = "[ERROR] Input value does not exist."
    }
}
