package racingcar.domain

class Round(val leftRound: Int) {

    init {
        require(leftRound in MIN_ROUND..MAX_ROUND) { ROUND_OUT_OF_RANGE_ERROR }
    }

    companion object {
        private const val MIN_ROUND: Int = 1
        private const val MAX_ROUND: Int = 10

        private const val ROUND_OUT_OF_RANGE_ERROR: String =
            "[ERROR] Round range must be between ${MIN_ROUND} and ${MAX_ROUND}."
    }
}
