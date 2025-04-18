package racingcar.domain

class Validator {
    fun validateCarNames(input: String) {
        val carNames = input.split(",").map { it.trim() }

        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }

        carNames.forEach { name ->
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car name cannot be empty")
            }

            if (name.length > 5) {
                throw IllegalArgumentException("Car name cannot exceed 5 characters: $name")
            }
        }
    }
    fun validateRoundCount(input: String) {
        try {
            val rounds = input.toInt()

            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be positive")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Number of rounds must be a valid integer")
        }
    }
}