package racingcar.enums

enum class ErrorMessage(val message: String) {
    ERR_INVALID_CAR_LIST("Car name input is invalid."),
    ERR_CAR_NAME_ISNULL("Car name cannot be empty."),
    ERR_INVALID_CAR_NAME_LENGTH("Car name must be 5 characters or fewer."),
    ERR_CAR_NAME_CONTAIN_INVALID_CHARACTER("Car name contains invalid characters."),
    ERR_NOT_ALLOW_DUPLICATED_NAME("Duplicate car names are not allowed."),
    ERR_NOT_ALLOW_NUMBER_INPUT("Input cannot be empty."),
    ERR_INPUT_NUMBER_IS_NOT_VALID("Input must be a valid number."),
    ERR_NUMBER_MUST_BE_POSITIVE_NUMBER("Input must be a positive integer."),
    ERR_NUMBER_CANT_OVER_MAX_LIMIT("Input must not exceed 1000.");
}
