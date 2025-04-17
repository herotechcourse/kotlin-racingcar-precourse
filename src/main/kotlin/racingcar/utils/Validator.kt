package racingcar.utils

object Validator {
    fun validateRounds(input: String): Int {
        val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Round count must be a number")
        require(rounds > 0) { "Round count must be positive" }
        return rounds
    }

    private fun validateCarName(name: String): String {
        require(name.isNotBlank()) { "Car name cannot be empty" }
        require(name.length <= 5) { "Car name cannot exceed 5 characters" }
        return name
    }

    fun validateCarNames(input: String): List<String> {
        require(input.isNotBlank()) { "At least one car name must be provided" }
        val names = input.split(",")
        val result: MutableList<String> = ArrayList<String>(names.size)

        for (name in names) {
            val trimmedName = name.trim()
            result.add(validateCarName(trimmedName))
        }
        return result
    }
}