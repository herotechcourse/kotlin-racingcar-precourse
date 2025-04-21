package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.validation.CarNameValidator
import racingcar.validation.RoundValidator

/**
 * Handles all user input for car names and round counts.
 */
object InputView {
    /**
     * Requests and reads comma-separated car names from the user.
     * Validates the parsed names and returns the cleaned list.
     */
    fun readCarNames(): List<String> {
        println("Enter the car names (comma-separated):")
        val input = Console.readLine()
        return CarNameValidator.validate(input.split(","))
    }

    /**
     * Requests and reads the number of rounds from the user.
     * Validates and returns the parsed round count.
     */
    fun readTotalRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return RoundValidator.validate(input)
    }
}
