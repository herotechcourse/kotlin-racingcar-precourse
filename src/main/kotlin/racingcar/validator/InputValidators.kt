package racingcar.validator

val MAX_CAR_COUNT = 100

object InputValidator {
    fun checkEmptyInput(input: String?) {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("[ERROR] Input cannot be empty.\n")
        }
    }

    fun checkMaxCarLimit(cars: List<String>) {
        if (cars.size > MAX_CAR_COUNT) {
            throw IllegalArgumentException("[ERROR] A maximum of 100 cars can be entered.\n")
        }
    }
}



