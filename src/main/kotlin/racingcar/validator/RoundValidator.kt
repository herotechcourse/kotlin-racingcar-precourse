package racingcar.validator

object RoundValidator {
    fun validate(rounds: Int) {
        require(rounds > 0) { "Number of rounds must be greater than 0" }
    }
}
