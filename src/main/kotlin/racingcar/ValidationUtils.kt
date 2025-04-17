package racingcar

object ValidationUtils {
    private fun checkLength(input: String) {
        if (input.length > 5) {
            throw IllegalArgumentException("Length exceeds 5")
        }
    }

    fun checkEmpty(input: String) {
        if (input.isEmpty()) {
                throw IllegalArgumentException("String is empty")
        }
    }

    fun requireValidName(name: String) {
        checkEmpty(name)
        checkLength(name)
    }
}