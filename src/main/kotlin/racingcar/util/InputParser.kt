package racingcar.util

object InputParser {

    fun parseCarNames(input: String): List<String> {
        return input.split(",").map { it }
    }
}