package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return InputValidator.validateCarNames(input)
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return InputValidator.validateRoundInput(input)
    }
}