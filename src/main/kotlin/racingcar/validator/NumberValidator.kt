package racingcar.validator

class NumberValidator {
    fun validate(input: String): Int {
        val num = input.toIntOrNull()
        return if (num != null) isValidRange(num) else throw IllegalArgumentException("The car number should be a number (not empty).")
    }

    private fun isValidRange(input: Int): Int {
        return if(input > 0) input else throw IllegalArgumentException("The round should be the positive number: $input")
    }
}