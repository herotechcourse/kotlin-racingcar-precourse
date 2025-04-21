package racingcar

object ParseAndValidate {
    fun parseAndValidateNames(input: String): List<String> {
        checkEmpty(input)
        return input
            .split(",")
            .map { it.trim() }
            .onEach  { validateName(it) }
    }

    fun parseAndValidateRounds(input: String): Int {
        val value = parseInt(input)
        checkPositive(value)
        return value
    }

    private fun checkLength(input: String) {
        if (input.length > 5)  throw IllegalArgumentException("Length exceeds 5")
    }

    private fun checkEmpty(input: String) {
        if (input.isEmpty()) throw IllegalArgumentException("String is empty")
    }

    private fun validateName(name: String) {
        checkEmpty(name)
        checkLength(name)
    }

    private fun parseInt(input: String) : Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("Input must be number")
    }

    private fun checkPositive(value: Int) {
        if (value < 1) throw IllegalArgumentException("Number must be greater than 0")
    }
}