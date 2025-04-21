package racingcar.validator

class NameValidator {
    fun validate(list: List<String>): List<String> {
        if (list.size < 2) {
            throw IllegalArgumentException("You must enter at least two car names, separated by commas.")
        }
        val names = list.map {it.trim()}

        for (item in names) {
            isValidChar(item)
            isValidLength(item)
        }
        return names
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