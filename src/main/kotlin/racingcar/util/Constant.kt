package racingcar.util

object Constant {
    const val MAX_CAR_NAME_SIZE = 4
    const val CAR_MOVEMENT_CONDITION = 4

    // Output Message
    const val CAR_NAME_MESSAGE = "Enter the names of the cars (comma-separated):"
    const val CAR_NAME_DELIMITER = ","
    const val ROUND_COUNT_MESSAGE = "How many rounds will be played?"
    const val RACE_RESULT_MESSAGE = "Race Results"
    const val CAR_POSITION_SYMBOL = "-"
    const val WINNER_MESSAGE = "Winners :"

    // Error Message
    const val CAR_NAME_EXCEED_ERROR_MESSAGE = "[ERROR] A car name cannot exceed 5 characters"
    const val CAR_NAME_CANNOT_BLANK_ERROR_MESSAGE = "[ERROR] A car name cannot be blank"
}