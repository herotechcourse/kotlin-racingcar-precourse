package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCarNames(): String {
        println(READ_CAR_NAMES_MESSAGE)
        val input = readInput()
        return input
    }

    private fun readInput(): String {
        val input = Console.readLine()
        require(input.trim().isNotBlank()) { INVALID_INPUT_ERROR }
        return input
    }

    companion object {
        private const val READ_CAR_NAMES_MESSAGE = "Enter the names of the cars (comma-separated):"
        private const val INVALID_INPUT_ERROR = "Input value does not exist."
    }
}
