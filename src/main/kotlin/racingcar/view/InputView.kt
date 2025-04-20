package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNames(): List<String> {
        println(MESSAGE_READ_CAR_NAMES)
        return Console.readLine().split(DELIMITERS)
    }

    fun readNumberOfRounds(): Int {
        println(MESSAGE_READ_NUMBER_OF_ROUNDS)
        return Console.readLine().toInt()
    }

    companion object {
        private const val MESSAGE_READ_CAR_NAMES = "Enter the names of the cars (comma-separated):"
        private const val MESSAGE_READ_NUMBER_OF_ROUNDS = "How many rounds will be played?"
        private const val DELIMITERS = ","
    }
}
