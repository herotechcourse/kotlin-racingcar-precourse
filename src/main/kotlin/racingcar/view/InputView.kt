package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCarNames(): List<String> {
        println(READ_CAR_NAMES_MESSAGE)
        val carNames = readInput()
        return carNames.split(CAR_NAME_DELIMITER)
    }

    fun readTotalRounds(): Int {
        println(READ_TOTAL_ROUNDS_MESSAGE)
        val input = readInput()
        val round = input.toIntOrNull()
        require(round != null) { INVALID_NUMBER_ERROR }
        return round
    }

    private fun readInput(): String {
        val input = Console.readLine()
        require(input.trim().isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }

    companion object {
        private const val READ_CAR_NAMES_MESSAGE = "Enter the names of the cars (comma-separated):"
        private const val READ_TOTAL_ROUNDS_MESSAGE = "How many rounds will be played?"

        private const val CAR_NAME_DELIMITER = ","

        private const val INVALID_INPUT_ERROR = "Input value does not exist."
        private const val INVALID_NUMBER_ERROR = "Input value must be a number."
    }
}
