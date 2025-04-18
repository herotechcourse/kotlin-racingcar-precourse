package racingcar

import camp.nextstep.edu.missionutils.Console

class InputHandler {

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return input.split(",").map(InputValidator::validateCarName)
    }

    fun readRoundNumber(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return InputValidator.validateRoundNumber(input)
    }
}
