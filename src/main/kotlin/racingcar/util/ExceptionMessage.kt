package racingcar.util

enum class ExceptionMessage(val message: String) {

    NAME_LENGTH_UNDER_1("Name must not under 1 characters"),
    NAME_LENGTH_EXCEED_5("Name must not exceed 5 characters"),
}