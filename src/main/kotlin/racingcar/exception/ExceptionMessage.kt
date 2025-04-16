package racingcar.exception

import racingcar.model.Rules

enum class ExceptionMessage(val message: String) {
    EMPTY_CAR_NAME("[ERROR] Car name can't be blank."),
    INVALID_NAME_FORMAT("[ERROR] Car names must be comma-separated."),
    DUPLICATE_CAR_NAME("[ERROR] Car names must be unique."),
    TOO_LONG_CAR_NAME("[ERROR] Car name must be 5 characters or less."),
    INVALID_ROUND_COUNT("[ERROR] Round count must be numeric and positive."),
    CAR_NAME_WITH_WHITESPACE("[ERROR] Car name must not contain whitespace."),
    INVALID_CHARACTER_IN_CAR_NAME("[ERROR] Car name must contain only letters and digits."),
    EXCEED_MAX_ROUND_COUNT("[ERROR] Round count must not exceed 500."),
    EXCEED_MAX_CAR_COUNT("[ERROR] Number of cars must not exceed 100.")
}
