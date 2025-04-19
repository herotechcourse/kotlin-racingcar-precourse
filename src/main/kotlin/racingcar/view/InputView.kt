package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.utils.Validator

/**
 * Handles user input for the racing car game.
 * Responsible for ask and get the car names and number of rounds form the user.
 */
object InputView {
    /**
     * Prompts the user for car names and validates the input.
     * Car names must be comma-separated and each name must be valid.
     */
    fun getCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return Validator.validateCarNames(input)
    }

    /**
     * Prompts the user for the number of rounds to play and validates the input.
     * The number of rounds must be a positive integer.
     */
    fun getRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return Validator.validateRounds(input)
    }
}