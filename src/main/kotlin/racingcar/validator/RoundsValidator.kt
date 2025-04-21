package racingcar.validator

private const val ZERO = 0

class RoundsValidator : InputValidator<Int> {
    override fun validate(raw: String): Int {
        val round = raw.toIntOrNull()
        require(round != null && round > ZERO) { "Rounds must be a positive integer." }
        return round
    }
}