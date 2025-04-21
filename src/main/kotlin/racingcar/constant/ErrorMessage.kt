package racingcar.constant

object ErrorMessage {
    const val TOTAL_ROUND_BLANK = "Total round cannot be blank."
    const val TOTAL_ROUND_NOT_NUMERIC = "Only positive integers are allowed for total round."
    const val TOTAL_ROUND_NOT_POSITIVE = "Number of rounds must be greater than 0."

    const val MINIMUM_CAR_COUNT = "At least two cars are required."
    const val CAR_NAME_BLANK = "Car names must not be empty or blank."
    const val CAR_NAME_DUPLICATE = "Car names must not be duplicated."
    const val CAR_NAME_TOO_LONG = "Car names must not exceed 5 characters."
}