package racingcar

object Validator {

    fun validateCarNames(names: List<String>) {
        if (names.isEmpty() || names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be 1–5 characters long.")
        }
    }

    fun validateRoundCount(rounds: Int) {
        if (rounds <= 0) throw IllegalArgumentException("Rounds must be greater than 0.")
    }
}
