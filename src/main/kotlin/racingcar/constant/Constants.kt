package racingcar.constant

const val ERROR_PREFIX: String = "[ERROR]"

object CarNamesError {
    const val INVALID_NAME_COUNT: String = """
        $ERROR_PREFIX You must enter at least 2 car names.
        Exit this program.
    """

    const val INVALID_NAME_LENGTH: String = """
        $ERROR_PREFIX Each car name must be 5 characters or less. 
        Exit this program.
    """
}