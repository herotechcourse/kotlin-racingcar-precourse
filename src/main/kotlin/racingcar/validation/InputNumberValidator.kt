package racingcar.validation

object InputNumberValidator {

    fun validateInputNumber(input: String): Int {
        val num = input.toIntOrNull() ?: throw IllegalArgumentException("Number of Rounds must be a number")

        if (num <= 0) {
            throw IllegalArgumentException("Number of rounds must be greater than 0")
        }

        return num
    }
}