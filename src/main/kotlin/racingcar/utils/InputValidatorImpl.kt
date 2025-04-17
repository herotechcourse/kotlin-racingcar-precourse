package racingcar.utils

class InputValidatorImpl: InputValidator {
    override fun validateCarName(carName: String): List<String> {
        val carNames = carName.split(",")
        carNames.forEach {
            if(it.trim().length > 5)
                throw IllegalArgumentException("Car name cannot exceed 5 characters long")
        }
        return carNames
    }

    override fun validateRounds(rounds: String): Int {
        return rounds.toIntOrNull() ?: throw IllegalArgumentException("Invalid round input")
    }

}