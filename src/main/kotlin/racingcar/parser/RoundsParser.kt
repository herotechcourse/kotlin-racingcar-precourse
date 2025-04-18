package racingcar.parser

object RoundsParser {
    private const val MAX_ROUNDS = 15
    private fun validateInputRounds(input: String): String {
        if (input.isEmpty()) throw IllegalArgumentException("The number of rounds cannot be empty and must be a valid number")
        if (input.toIntOrNull() == null) throw IllegalArgumentException("Rounds must be a number")
        if (input.toInt() < 1) throw IllegalArgumentException("Rounds must be more than 0")
        if (input.toInt() > MAX_ROUNDS) throw IllegalArgumentException("Rounds must be less than $MAX_ROUNDS")
        return input
    }

    fun parse(input: String): Int {
        return validateInputRounds(input).toInt()
    }
}