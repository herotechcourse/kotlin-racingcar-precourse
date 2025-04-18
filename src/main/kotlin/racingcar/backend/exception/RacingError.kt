package racingcar.backend.exception

enum class RacingError(val message: String) {
    CAR_NAME_BLANK("Each car must have a name."),
    CAR_NAME_TOO_LONG("Car name cannot exceed 5 characters."),
    CAR_NAME_DUPLICATE("Car names must be unique."),
    INSUFFICIENT_CARS("At least two cars are required."),
    INVALID_ROUND("Number of rounds must be a valid number."),
}