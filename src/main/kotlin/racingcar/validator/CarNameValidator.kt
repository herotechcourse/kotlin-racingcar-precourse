package racingcar.validator

object CarNameValidator {
    private const val MAX_NAME_LENGTH = 5

    fun validate(names: List<String>) {
        validateNotEmpty(names)
        names.forEach { validateName(it) }
    }

    private fun validateNotEmpty(names: List<String>) {
        require(names.isNotEmpty()) { "Car names cannot be empty" }
    }

    private fun validateName(name: String) {
        require(name.isNotEmpty()) { "Car name cannot be empty" }
        require(name.length <= MAX_NAME_LENGTH) { "Car name cannot exceed $MAX_NAME_LENGTH characters: $name" }
    }
}
