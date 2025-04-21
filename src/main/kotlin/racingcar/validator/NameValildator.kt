package racingcar.validator

class NameValidator {
    fun validate(list: List<String>): List<String> {
        for (item in list) {
            isValidChar(item)
            isValidLength(item)
        }
        return list
    }

    private fun isValidChar(input: String): Boolean {
        if (input.isBlank()) {
            throw IllegalArgumentException("The car name can't be empty.")
        }
        return true
    }

    private fun isValidLength(input: String): Boolean {
        if (input.length !in 1..5) {
            throw IllegalArgumentException("The car name can't be longer than 5 characters: $input")
        }
        return true
    }
}