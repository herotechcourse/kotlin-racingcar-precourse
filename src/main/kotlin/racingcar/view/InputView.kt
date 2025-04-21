package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun carNamesInput(): String {
        printCarNamesInputMessage()
        return Console.readLine()
    }

    private fun printCarNamesInputMessage() {
        println(CAR_NAME_INPUT_MESSAGE)
    }

    fun gameRoundInput(): String {
        printGameRoundInputMessage()
        return Console.readLine()
    }

    private fun printGameRoundInputMessage() {
        println(TRY_INPUT_MESSAGE)
    }

    companion object {
        private const val CAR_NAME_INPUT_MESSAGE = "Enter the names of the cars (comma-separated) :"
        private const val TRY_INPUT_MESSAGE = "How many rounds will be played?"
    }
}
