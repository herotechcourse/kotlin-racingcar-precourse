package racingcar.validation

/**
 * Validates and parses the number of rounds.
 *
 * @param input raw input string
 * @return positive integer number of rounds
 * @throws IllegalArgumentException on invalid input
 */
object RoundCountValidator : Validator<String, Int> {
    override fun validate(input: String): Int {
        val n = input.toIntOrNull()

        require(n != null && n > 0) { "Number of rounds must be a positive integer." }
        require(n <= Int.MAX_VALUE) { "Number of rounds exceeds maximum value." }

        return n
    }
}
