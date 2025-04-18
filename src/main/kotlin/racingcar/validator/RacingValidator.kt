package racingcar.validator

class RacingValidator {
    fun validateCarNames(carNames: List<String>) {
        for (carName in carNames) {
            if (carName.length > 5) {
                throw IllegalArgumentException("Car name should not exceed 5 characters")
            }
        }
    }
}