package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun inputCarNames() : List<String> {
        println(CAR_NAME_PROMPT)
        val input = Console.readLine().split(COMMA_DELIMITER)
        validateName(input)
        return input
    }

    fun inputRounds() : Int {
        println(ROUND_PROMPT)
        val input = Console.readLine()
        val rounds = input.toIntOrNull() ?: throw IllegalArgumentException(INVALID_ROUND_MESSAGE)
        validateRound(rounds)
        return rounds
    }

    fun validateRound(round : Int) {
        if (round <= 0)
            throw IllegalArgumentException(NON_POSITIVE_ROUND_MESSAGE)
    }

    fun validateName(names : List<String>) {
        var valid = mutableSetOf<String>()
        for (name in names) {
            if (name.isBlank() || name.length > 5)
                throw IllegalArgumentException(INVALID_CAR_NAME_MESSAGE)
            if (!valid.add(name))
                throw IllegalArgumentException(DUPLICATE_NAME_MESSAGE)
        }
    }

    private const val CAR_NAME_PROMPT = "Enter the names of the cars (comma-separated):"
    private const val ROUND_PROMPT = "How many rounds will be played?"
    private const val COMMA_DELIMITER = ","
    private const val INVALID_ROUND_MESSAGE = "Rounds must be a number."
    private const val NON_POSITIVE_ROUND_MESSAGE = "Number of rounds must be a positive integer."
    private const val INVALID_CAR_NAME_MESSAGE = "Each car name must be 1-5 characters."
    private const val DUPLICATE_NAME_MESSAGE = "Duplicate name is not allowed."

}
