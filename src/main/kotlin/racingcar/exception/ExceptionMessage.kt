package racingcar.exception

import racingcar.model.Rules

enum class ExceptionMessage {
    EMPTY_CAR_NAME {
        override val message = "[ERROR] Car name can't be blank."
    },
    TOO_LONG_CAR_NAME {
        override val message: String
            get() = "[ERROR] Car name must be ${Rules.CAR_NAME_MAX_LENGTH} characters or less."
    },
    EXCEED_MAX_ROUND_COUNT {
        override val message: String
            get() = "[ERROR] Round count must not exceed ${Rules.MAX_ROUND_COUNT}."
    },
    EXCEED_MAX_CAR_COUNT {
        override val message: String
            get() = "[ERROR] Number of cars must not exceed ${Rules.MAX_CAR_COUNT}."
    },
    INVALID_NAME_FORMAT {
        override val message = "[ERROR] Car names must be comma-separated."
    },
    DUPLICATE_CAR_NAME {
        override val message = "[ERROR] Car names must be unique."
    },
    INVALID_ROUND_COUNT {
        override val message = "[ERROR] Round count must be numeric and positive."
    },
    CAR_NAME_WITH_WHITESPACE {
        override val message = "[ERROR] Car name must not contain whitespace."
    },
    INVALID_CHARACTER_IN_CAR_NAME {
        override val message = "[ERROR] Car name must contain only letters and digits."
    };

    abstract val message: String
}
