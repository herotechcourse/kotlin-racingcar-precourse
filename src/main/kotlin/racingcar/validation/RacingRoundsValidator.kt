package racingcar.validation

object RacingRoundsValidator {
    private const val ERROR_PREFIX: String = "[ERROR]"

    private const val ZERO_NOT_ALLOWED: String = """
        $ERROR_PREFIX Racing round must be greater than 0.
        Exit this program.
    """
    private const val INVALID_TYPE: String = """
        $ERROR_PREFIX You must enter type of Number.
        Exit this program.
    """

    fun validate(racingRound: String): Boolean {
        if (racingRound == "0") {
            throw IllegalArgumentException(ZERO_NOT_ALLOWED)
        }

        if (!(racingRound.matches("\\d+".toRegex()))) {
            throw IllegalArgumentException(INVALID_TYPE)
        }

        return true
    }
}
