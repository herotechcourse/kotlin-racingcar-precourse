package racingcar.utils

class InputValidatorImpl: InputValidator {
    override fun validateCarName(carName: String): List<String> {
        val carNames = carName.split(",").map{ it.trim() }.filter{ it.isNotEmpty() }
        carNames.forEach {
            if(it.length > 5)
                throw IllegalArgumentException("Car name cannot exceed 5 characters long")
        }
        return carNames
    }

    override fun validateRounds(rounds: String): Int {
        return rounds.toIntOrNull().takeIf { it in 0..1_000_000 } ?: throw IllegalArgumentException("Invalid round input")
    }

}