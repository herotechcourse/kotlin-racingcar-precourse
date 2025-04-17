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

    fun parseAndValidateNames(input: String): List<String> {
        checkEmpty(input)
        return input
            .split(",")
            .map { it.trim() }
            .onEach  { requireValidName(it) }
    }
}