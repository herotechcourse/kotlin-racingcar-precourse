package racingcar.frontend

import camp.nextstep.edu.missionutils.Console

/**
 * Handles user input/output interactions.
 */
object Frontend {

    /**
     * Reads the raw car names from input.
     * No parsing or validation done here.
     */
    fun readCarNames(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }

    /**
     * Reads the raw rounds count from input.
     * No parsing or validation done here.
     */
    fun readRounds(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }
}
