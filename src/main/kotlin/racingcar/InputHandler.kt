package racingcar

object InputHandler {
    fun parseCarNames(input: String): List<String> {
        val names = input.split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
        validateCarNames(names)
        return names
    }

    private fun validateCarNames(names: List<String>) {
        if (names.isEmpty()) {
            throw IllegalArgumentException("No car names were entered.")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be at most 5 characters.")
        }
    }

    fun parseRounds(input: String): Int {
        val rounds = input.toIntOrNull()
        if (rounds == null || rounds <= 0) {
            throw IllegalArgumentException("Rounds must be a positive integer.")
        }

        return rounds
    }
}