package racingcar.domain

object ErrorMessages {

    // Car
    const val CAR_NAME_MISSING        = "Car name is missing."
    const val CAR_NAME_TOO_LONG       = "Car name exceeds 5 characters."

    // Cars
    const val CARS_MINIMUM_COUNT      = "Number of car names must be at least 2."
    const val CARS_NO_DUPLICATES      = "Duplicate car names found."

    // Rounds
    const val ROUND_LESS_THAN_ONE     = "Number of rounds must be greater than 0."
}
