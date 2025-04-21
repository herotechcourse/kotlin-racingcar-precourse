package racingcar.validator

object InputValidator {

    fun isInputEmpty(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("Empty input")
        }
    }

    fun allNamesLessThanMaxLength(names: List<String>, maxLength: Int) {
        names.forEach {
            if (it.length > maxLength) {
                throw IllegalArgumentException("Length of name must be less than $maxLength")
            }
        }
    }

    fun isNumber(input: String) : Int {
        val v = input.toIntOrNull()
            ?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Input value must be a positive integer")
        return v
    }
}