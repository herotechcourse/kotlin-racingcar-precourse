package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator

object InputManager {

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return parseCarNames(input)
    }

    fun readTries(): Int
    {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return parseTries(input)
    }

    private fun parseCarNames(input: String): List<String> {
        requireNotNull(input) { "[ERROR] Car names input cannot be null." }
        val names = input.split(",").map { it.trim() }
        Validator.validateCars(names)
        return names
    }

    private fun parseTries(input: String?): Int {
        Validator.validateTries(input)
        return input!!.toInt()
    }


}