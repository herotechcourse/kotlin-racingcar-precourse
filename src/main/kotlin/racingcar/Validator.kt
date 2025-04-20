package racingcar

class Validator {

    fun validateEachName(names: List<String>, limit: Int) {
        names.forEach {
            validateName(it, limit)
        }
    }

    fun validateName(name: String, limit: Int) {
        if (name.isLengthExceedsLimit(limit) || name.isBlank()) {
            throw IllegalArgumentException("Car name can be entered up to $limit characters, and empty or blank is not possible.")
        }
    }

    fun validateStringToInt(stringValue: String): Int {
        return stringValue.toIntOrNull()
            ?: throw IllegalArgumentException("Only numbers can be entered")
    }

    private fun String.isLengthExceedsLimit(limit: Int) = length > limit
}
