package racingcar

object Validator {
    fun validateCarNames(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("At least one car name must be provided")
        }

        val names = input.split(",").map { it.trim() }

        if (names.isEmpty() || names.any { it.isEmpty() }) {
            throw IllegalArgumentException("Car name cannot be empty")
        }

        names.forEach {
            if (it.length > 5) throw IllegalArgumentException("Car name cannot be longer than 5 characters")
        }

        return names
    }

    fun validateRounds(input: String?): Int {
        val number = input?.toIntOrNull()
            ?: throw IllegalArgumentException("Input must be a number")

        if (number <= 0) {
            throw IllegalArgumentException("Number of rounds must be greater than 0")
        }

        return number
    }
}
