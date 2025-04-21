package racingcar.util

object Parser {
    fun parseCarName(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException()
        }
        return input.split(",")
    }
}
