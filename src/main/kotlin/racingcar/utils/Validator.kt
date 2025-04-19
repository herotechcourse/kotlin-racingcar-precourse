package racingcar.utils

/**
 * Utility object for validating user input in the racing car game.
 * Provides methods to validate rounds number and car names according to game rules.
 */
object Validator {
    /**
     * Validates, convert the input and return the number of race rounds.
     */
    fun validateRounds(input: String): Int {
        val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Round count must be a number")
        require(rounds > 0) { "Round count must be positive" }
        return rounds
    }

    /**
     * Validate a single car name according the game rules.
     * throw IllegalArgumentException if name is blank or exceeds 5 characters.
     */
    private fun validateCarName(name: String): String {
        require(name.isNotBlank()) { "Car name cannot be empty" }
        require(name.length <= 5) { "Car name cannot exceed 5 characters" }
        return name
    }

    /**
     * Validates a comma-separated list of car names.
     * return a list of validated car names, or throw IllegalArgumentException if input in blank or any car name is invalid
     */
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