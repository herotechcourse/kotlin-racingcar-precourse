package racingcar

object InputHandler {

    fun parseCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        if (names.isEmpty() || names.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("Car names must be non-empty and up to 5 characters.")
        }
        return names
    }

    fun parseRoundCount(input: String): Int {
        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("Round count must be a number.")
        if (rounds <= 0) throw IllegalArgumentException("Round count must be greater than zero.")
        return rounds
    }
}
