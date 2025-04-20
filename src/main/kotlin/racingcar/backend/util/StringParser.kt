package racingcar.backend.util

object StringParser {
    fun parseCommaSeperated(input: String): List<String> {
        return input.split(",")
    }
}