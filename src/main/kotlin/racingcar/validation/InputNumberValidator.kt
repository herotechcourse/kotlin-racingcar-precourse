package racingcar.validation

object InputNumberValidator {

    fun validateInputNumber(num: Int) {
        if (num <= 0) {
            throw IllegalArgumentException("Number of rounds must be greater than 0")
        }
    }
}