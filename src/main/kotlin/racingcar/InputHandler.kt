package racingcar

class InputHandler {
    fun parseCarNames(input: String): List<String> {
        val names = input.split(",")
            .map { it.trim() }
        validateCarNames(names)
        return names
    }

    private fun validateCarNames(names: List<String>) {
        if (names.isEmpty()) {
            throw IllegalArgumentException("No car names were entered.")
        }
        if (names.any { it.isEmpty() }) {
            throw IllegalArgumentException("Car names cannot be blank")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be at most 5 characters.")
        }

        if (names.toSet().size != names.size) {
            throw IllegalArgumentException("Car names must be unique.")
        }
    }

    fun parseRounds(input: String): Int {
        val rounds = input.trim()
            .toIntOrNull()
        if (rounds == null || rounds <= 0) {
            throw IllegalArgumentException("Rounds must be a positive integer.")
        }

        return rounds
    }
}