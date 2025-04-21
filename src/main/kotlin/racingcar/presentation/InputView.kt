package racingcar.presentation

import camp.nextstep.edu.missionutils.Console

object InputView {

    /**
     * Read car names from console input, parse them, and return them as a list.
     */
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")

        return CarNameParser.parse(Console.readLine())
    }
}
