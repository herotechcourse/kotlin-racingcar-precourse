package racingcar.validation

/**
 * Utility class to validate the round count input.
 * Ensures the value is a positive integer greater than zero.
 */
object RoundValidator {
    fun validate(input: String): Int {
        val num = input.toIntOrNull() ?: throw IllegalArgumentException("Round count must be a valid integer.")
        require(num > 0) { "Round count must be greater than 0." }
        return num
    }
}
