package racingcar.constants

object InputMessages {
    const val CAR_NAMES = "Enter the names of the cars (comma-separated):"
    const val ATTEMPTS = "How many rounds will be played?"
}

object ErrorMessages {
    object Name {
        const val LIST_CANNOT_BE_EMPTY = "Please enter at least one car name."
        const val CANNOT_BE_BLANK = "Car names cannot be blank or contain only spaces."
        const val CANNOT_BE_TOO_LONG = "Car names cannot be longer than 5 characters."
    }
    object Round{
        const val INVALID_FORMAT = "Please enter a valid number for the rounds."
        const val MUST_BE_AT_LEAST_ONE = "The number of rounds must be at least 1."
    }
}