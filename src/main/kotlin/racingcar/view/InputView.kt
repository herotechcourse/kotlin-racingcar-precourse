package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val parser = InputParser()

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return parser.parseCarNames(input)
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return parser.parseNumberOfRounds(input)
    }
}
