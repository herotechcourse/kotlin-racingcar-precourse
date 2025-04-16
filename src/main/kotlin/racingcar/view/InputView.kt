package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val parser = InputParser()

    fun readCarNames(): List<String> {
        val input = Console.readLine()
        return parser.parseCarNames(input)
    }
}
