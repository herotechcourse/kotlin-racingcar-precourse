package racingcar.exception

enum class InputCountExceptionMessage(private val message: String) {
    BLANK_COUNT("Blank input was provided."),
    IMPOSSIBLE_CONVERT_NUMBER("The input is not a valid number."),
    INVALID_INTEGER_SCOPE("The input exceeds the range of a valid integer."),
    UNDER_MINIMUM_COUNT("The number must be greater than or equal to 1.");

    override fun toString(): String {
        return message
    }
}
