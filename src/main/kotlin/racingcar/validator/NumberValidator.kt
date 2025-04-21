package racingcar.validator

class NumberValidator {
    fun validate(input: String): Boolean {
        val num = input.toIntOrNull()
        return if (num != null) isValidRange(num) else throw IllegalArgumentException("The car number should be a number (not empty).")
    }

    private fun isValidRange(input: Int): Boolean {
        return if(input > 0) true else throw IllegalArgumentException("The round should be the positive number: $input")
    }
}