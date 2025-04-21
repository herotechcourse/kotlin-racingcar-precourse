package racingcar.presentation

object CarNameParser {

    /**
     * Parses a comma-separated string of car names,
     * trims whitespace from each name, and returns them as a list.
     */
    fun parse(rawInput: String): List<String> =
        rawInput.split(",").map { it.trim() }
}
