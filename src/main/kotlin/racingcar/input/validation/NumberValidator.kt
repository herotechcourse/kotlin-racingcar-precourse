package racingcar.validation

internal const val INVALID_NUMBER_FORMAT_MSG = "Invalid Number Format."
internal const val INVALID_NATURAL_NUMBER_MSG = "Number must be a natural number."


fun validateNumberFormat(input: String) {
    if (input.toIntOrNull() == null)
        throw IllegalArgumentException(INVALID_NUMBER_FORMAT_MSG);
}
fun validateNatural(num: Int) {
    if (num < 1)
        throw IllegalArgumentException(INVALID_NATURAL_NUMBER_MSG);
}