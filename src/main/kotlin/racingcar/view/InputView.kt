package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.parser.CarNameParser
import racingcar.validator.CarNameValidator
import racingcar.validator.RoundValidator

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = CarNameParser.parse(input)
        CarNameValidator.validate(names)
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val rounds = try {
            Console.readLine().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Number of rounds must be a valid integer")
        }
        RoundValidator.validate(rounds)
        return rounds
    }
}
