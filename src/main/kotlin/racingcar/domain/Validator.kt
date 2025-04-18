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
}