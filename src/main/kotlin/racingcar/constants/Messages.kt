package racingcar.constants

object Messages {

    object Prompt {
        const val CAR_NAME_INPUT = "Enter the names of the cars (comma-separated):"
        const val ROUND_COUNT_INPUT = "How many rounds will be played?"
    }

    object Error {
        const val EMPTY_INPUT = "[ERROR] Input cannot be empty.\n"
        const val MAX_CAR_LIMIT = "[ERROR] A maximum of %d cars can be entered.\n"
        const val INVALID_CAR_NAME_LENGTH = "[ERROR] Car names must be within %d–%d characters.\n"
        const val INVALID_CAR_NAME_FORMAT = "[ERROR] Car names can only contain letters and numbers.\n"
        const val DUPLICATE_CAR_NAMES = "[ERROR] Duplicate car names are not allowed.\n"
        const val INVALID_ROUND_NUMBER = "[ERROR] Number of rounds must be a positive integer.\n"
    }

    object Output {
        const val RESULT_TITLE = "Race Results"
        const val WINNERS_LABEL = "Winners :"

    }
}