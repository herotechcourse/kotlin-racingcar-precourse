package racingcar.utils

class InputValidatorImpl: InputValidator {
    override fun validateCarName(carName: String) {
        TODO("Not yet implemented")
    }

    override fun validateRounds(rounds: String): Int {
        return rounds.toIntOrNull() ?: throw IllegalArgumentException("Invalid round input")
    }

}