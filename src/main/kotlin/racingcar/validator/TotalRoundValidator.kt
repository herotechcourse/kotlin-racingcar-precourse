package racingcar.validator

object TotalRoundValidator {

    fun validate(totalRound: String) {
        requireNotBlank(totalRound)
        requireOnlyDigits(totalRound)
        requirePositive(totalRound)
    }

    private fun requireNotBlank(totalRound: String) {
        require(totalRound.isNotBlank()) {
            "Total round cannot be blank."
        }
    }

    private fun requireOnlyDigits(totalRound: String) {
        require(totalRound.all { it.isDigit() }) {
            "Only positive integers are allowed for total round."
        }
    }

    private fun requirePositive(totalRound: String) {
        require(totalRound.toInt() > 0) {
            "Number of rounds must be greater than 0."
        }
    }
}