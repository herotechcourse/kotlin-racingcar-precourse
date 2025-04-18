package racingcar.parser

object CarNameParser {
    fun parse(input: String): List<String> {
        return input.split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
    }
}
