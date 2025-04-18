package racingcar.util

object InputValidator {
    fun validateCarNames(carNames: List<String>) {
        // car name is blank
        if (carNames.any { it.isBlank() }) {
            throw IllegalArgumentException("Car names must not be blank")
        }

        // car name too long
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("Car name must be 5 characters or less")
        }
    }

    fun validateRoundCnt(round: String): Int {
        return round.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Round must be positive integer")
    }
}