package racingcar.exception

import racingcar.model.Constants

enum class ExceptionMessage(val message: String) {
    EMPTY_CAR_NAME("[ERROR] Car name cannot be empty"),
    TOO_LONG_CAR_NAME("[ERROR] Car name cannot exceed ${Constants.MAX_NAME_LENGTH} characters"),
    INVALID_ROUND_COUNT("[ERROR] Round count must be a positive number"),
    EXCEED_MAX_ROUND_COUNT("[ERROR] Round count must not exceed ${Constants.MAX_ROUND_COUNT}"),
    EXCEED_MAX_CAR_COUNT("[ERROR] Number of cars must not exceed ${Constants.MAX_CAR_COUNT}"),
    DUPLICATE_CAR_NAME("[ERROR} Car name must be unique"),
    WHITESPACE_IN_CAR_NAME("[ERROR] Car name must not contain whitespace"),
    INVALID_CHARACTER_IN_CAR_NAME("[ERROR] Car name must contain only letters and digits"),
    NO_CARS_PROVIDED("[ERROR] At least one car name must be provided")
}