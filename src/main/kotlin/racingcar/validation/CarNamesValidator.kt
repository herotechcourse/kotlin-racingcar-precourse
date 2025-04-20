package racingcar.validation

object CarNamesValidator {
    const val ERROR_PREFIX: String = "[ERROR]"

    const val INVALID_NAME_COUNT: String = """
        $ERROR_PREFIX You must enter at least 2 car names.
        Exit this program.
    """
    const val DUPLICATION_NOT_ALLOWED: String = """
        $ERROR_PREFIX Each car name must be unique.
        Exit this program.
    """
    const val INVALID_NAME_LENGTH: String = """
        $ERROR_PREFIX Each car name must be 5 characters or less. 
        Exit this program.
    """

    fun validate(carNames: List<String>): Boolean {
        if (carNames.size == 1) {
            throw IllegalArgumentException(INVALID_NAME_COUNT)
        }

        if (carNames.distinct().size != carNames.size) {
            throw IllegalArgumentException(DUPLICATION_NOT_ALLOWED)
        }

        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException(INVALID_NAME_LENGTH)
        }

        return true
    }
}