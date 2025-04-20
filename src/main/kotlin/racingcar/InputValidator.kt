package racingcar

object InputValidator {
    fun validateCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }

        if (names.isEmpty() || names.any { it.isBlank() }) {
            throw IllegalArgumentException("Car names cannot be empty or blank.")
        }

        names.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("Car name '$it' exceeds 5 characters.")
            }
        }

        return names
    }

    fun validateRoundCount(input: String): Int {
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
    }
}
