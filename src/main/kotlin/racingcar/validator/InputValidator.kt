package racingcar.validator

class InputValidator {
    fun validateCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        require(names.isNotEmpty()) { "Car names must not be empty." }
        names.forEach { name ->
            require(name.isNotEmpty()) { "Car name must not be empty." }
            require(name.length <= 5) { "Car name '$name' must be at most 5 characters." }
        }
        // no duplicates allowed
        require(names.distinct().size == names.size) { "Duplicate car names are not allowed." }
        return names
    }

    fun validateRounds(input: String): Int {
        val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number.")
        require(rounds >= 1) { "Rounds must be at least 1." }
        return rounds
    }
}