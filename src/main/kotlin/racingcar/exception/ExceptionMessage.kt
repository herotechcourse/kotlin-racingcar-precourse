package racingcar.exception

enum class ExceptionMessage(val message: String) {
    EMPTY_CAR_NAME("[ERROR] Car name can't be blank."),
    INVALID_NAME_FORMAT("[ERROR] Car names must be comma-separated."),
    DUPLICATE_CAR_NAME("[ERROR] Car names must be unique."),
    TOO_LONG_CAR_NAME("[ERROR] Car name must be 5 characters or less."),
    INVALID_ROUND_COUNT("[ERROR] Round count must be numeric and positive.")
}
