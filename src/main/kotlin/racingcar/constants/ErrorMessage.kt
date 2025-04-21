package racingcar.constants

object ErrorMessages {
    const val INVALID_NUMBER = "Please enter a valid number."
    const val NON_POSITIVE_ROUND = "Round count must be greater than 0."
    const val EMPTY_NAME_LIST = "Car name list cannot be empty."
    const val BLANK_CAR_NAME = "Car name cannot be blank."
    fun carNameTooLong(name: String) = "Car name must be 5 characters or less: '$name'"
}
