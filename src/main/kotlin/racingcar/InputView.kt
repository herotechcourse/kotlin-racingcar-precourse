package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        Validator.validateCarNames(names)
        return names
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()

        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("Please enter a valid number.")

        Validator.validateRoundCount(rounds)
        return rounds
    }
}
