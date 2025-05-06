package racingcar

class Validator {

    fun validateCarsName(carsName: List<String>) {
        validateCarsNameLength(carsName)
        validateNumberOfCar(carsName)
        validateDuplicateCarNames(carsName)
    }

    fun validateRound(round: String) {
        validateRoundType(round)
        validateNumberOfRound(round.toInt())
    }

    private fun validateCarsNameLength(carsName: List<String>) {
        carsName.forEach { name ->
            if (name.isEmpty() || name.length > 5) {
                throw IllegalArgumentException("Each car name must contain 1 to 5 characters.")
            }
        }
    }

    private fun validateNumberOfCar(carsName: List<String>) {
        if (carsName.size < 2) {
            throw IllegalArgumentException("At least two car names must be provided to start the race.")
        }
    }

    private fun validateDuplicateCarNames(carNames: List<String>) {
        if (carNames.toSet().size != carNames.size) {
            throw IllegalArgumentException("Car names must be unique to start the race.")
        }
    }

    private fun validateRoundType(round: String) {
        if (round.toIntOrNull() == null) {
            throw IllegalArgumentException("Round must be a number.")
        }
    }

    private fun validateNumberOfRound(round: Int) {
        if (round < 1) {
            throw IllegalArgumentException("Number of rounds must be at least 1 to start the race.")
        }
    }
}