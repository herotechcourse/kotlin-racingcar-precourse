package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun askCarNames(): String {
        println(ASKING_CAR_NAMES)
        return Console.readLine()
    }

    fun askRounds(): Int {
        println(ASKING_ROUNDS)
        return parseAndValidateInt(Console.readLine())
    }

    companion object {
        private const val ASKING_CAR_NAMES = "Enter the names of the cars (comma-separated):"
        private const val ASKING_ROUNDS = "How many rounds will be played?"
    }
}