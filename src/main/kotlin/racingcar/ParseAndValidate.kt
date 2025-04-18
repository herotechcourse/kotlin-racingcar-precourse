package racingcar

object ParseAndValidate {
    private fun checkLength(input: String) {
        if (input.length > 5) {
            throw IllegalArgumentException("Length exceeds 5")
        }
    }

    private fun checkEmpty(input: String) {
        if (input.isEmpty()) {
                throw IllegalArgumentException("String is empty")
        }
    }

    private fun requireValidName(name: String) {
        checkEmpty(name)
        checkLength(name)
    }

    private fun checkInt(input: String) : Int {
        return input.toIntOrNull(10) ?: throw IllegalArgumentException("Input must be number")
    }

    private fun checkIntValue(value: Int) {
        if (value < 1) throw IllegalArgumentException("Number must be greater than 0")
    }

    fun parseAndValidateNames(input: String): List<String> {
        checkEmpty(input)
        return input
            .split(",")
            .map { it.trim() }
            .onEach  { requireValidName(it) }
    }

    fun parseAndValidateRounds(input: String): Int {
        val value = checkInt(input)
        checkIntValue(value)
        return value
    }
}