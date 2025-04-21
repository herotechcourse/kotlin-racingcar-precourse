package racingcar.presentation

import camp.nextstep.edu.missionutils.Console
import racingcar.presentation.parser.CarNameParser
import racingcar.presentation.parser.RoundParser

object InputView {

    /**
     * Read car names from console input, parse them, and return them as a list.
     */
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")

        return CarNameParser.parse(Console.readLine())
    }

    fun readRounds(): Int {
        println("How many rounds will be played?")

        return RoundParser.parse(Console.readLine())
    }
}
