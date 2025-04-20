package racingcar.util

object InputParser {
    fun parseCarName(input: String): List<String> {
        return input.split(",").map { it.trim() }
    }
}