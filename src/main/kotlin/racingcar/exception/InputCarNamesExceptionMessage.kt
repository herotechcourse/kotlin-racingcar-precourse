package racingcar.exception

enum class InputCarNamesExceptionMessage(private val message: String) {
    BLANK_CAR_NAME("Blank input was provided."),
    DUPLICATED_CAR_NAME("Duplicate car name entered"),
    INVALID_CAR_NAME("Name length exceeds 5 characters.");

    override fun toString(): String {
        return message
    }
}
