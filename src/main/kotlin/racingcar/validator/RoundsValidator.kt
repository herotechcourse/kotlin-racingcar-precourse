package racingcar.validator

class RoundsValidator : InputValidator<Int> {
    override fun validate(raw: String): Int {
        val n = raw.toIntOrNull()
        require(n != null && n > 0) { "Rounds must be a positive integer." }
        return n
    }
}