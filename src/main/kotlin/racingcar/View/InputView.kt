package racingcar.view

import camp.nextstep.edu.missionutils.Console

/**
 * Handles user input for the racing car game.
 * This class is responsible for displaying prompts and collecting user input.
 */
object InputView {
    /**
     * Prompts the user to enter car names and returns the input.
     *
     * @return A string containing comma-separated car names
     */
    fun readCarNames(): String {
        println(CAR_NAMES_PROMPT)
        return Console.readLine()
    }

    /**
     * Prompts the user to enter the number of rounds and returns the input.
     *
     * @return A string containing the number of rounds
     */
    fun readRounds(): String {
        println(ROUNDS_PROMPT)
        return Console.readLine()
    }

    private const val CAR_NAMES_PROMPT = "Enter the names of the cars (comma-separated):"
    private const val ROUNDS_PROMPT = "How many rounds will be played?"
}