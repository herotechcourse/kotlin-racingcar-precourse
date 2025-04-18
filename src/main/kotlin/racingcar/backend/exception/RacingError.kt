package racingcar.backend.exception

enum class RacingError(val message: String) {
    CAR_NAME_BLANK("Each car must have a name."),
    ;
}