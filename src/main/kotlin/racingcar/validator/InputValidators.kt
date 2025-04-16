package racingcar.validator

val MAX_CAR_COUNT = 100
val MAX_CAR_NAME_LENGTH = 5
val MIN_CAR_NAME_LENGTH = 1

object InputValidator {
    fun checkEmptyInput(input: String?) {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.\n")
        }
    }

    fun validateCarNames(carNames: List<String>) {
        checkMaxCarLimit(carNames)

        carNames.forEach { carName ->
            checkCarNameLength(carName)
        }
    }

    private fun checkMaxCarLimit(cars: List<String>) {
        if (cars.size > MAX_CAR_COUNT) {
            throw IllegalArgumentException("[ERROR] A maximum of $MAX_CAR_COUNT cars can be entered.\n")
        }
    }

    private fun checkCarNameLength(carName: String) {
        if (carName.length < MIN_CAR_NAME_LENGTH || carName.length > MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException("[ERROR] Car names must be within $MIN_CAR_NAME_LENGTH–$MAX_CAR_NAME_LENGTH characters.\n")
        }
    }
}



