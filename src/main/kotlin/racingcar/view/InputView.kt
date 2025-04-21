package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputCarNames() : List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine().split(",")
        validateName(input)
        return input
    }

    fun inputRounds() : Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number.")
        validateRound(rounds)
        return rounds
    }

    fun validateRound(round : Int) {
        if (round <= 0)
            throw IllegalArgumentException("Number of rounds must be a positive integer.")
    }

    fun validateName(names : List<String>) {
        var valid = mutableSetOf<String>()
        for (name in names) {
            if (name.isBlank() || name.length > 5)
                throw IllegalArgumentException("Each car name must be 1-5 characters.")
            if (!valid.add(name))
                throw IllegalArgumentException("Duplicate name is not allowed.")
        }
    }

}
