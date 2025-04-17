package racingcar.validation

object CarNameValidator {

    // Define Maximum length of Car Names
    private const val MAX_LENGTH = 5

    // 1. Data Validation - Validate Invalid Characters
    fun validateSeparator(input: String) {
        if (input.contains(Regex("[^a-zA-Z0-9, ]"))) {
            throw IllegalArgumentException("Invalid character detected")
        }
    }

    // 2. Data Validation - Must Have Value
    private fun validateNotNullOrBlank(carName: String?) {
        if (carName.isNullOrBlank()) {
            throw IllegalArgumentException("Car name cannot be null or blank")
        }
    }

    // 3. Data Validation - Exceed Maximum Length
    private fun validateLength(carName: String) {
        if (carName.length > MAX_LENGTH) {
            throw IllegalArgumentException("Car name '$carName' exceeds max length of $MAX_LENGTH.")
        }
    }

    // 4. Data Validation - Validate Car Name for Internal Spaces
    fun validateCarName(name: String) {
        if (name.contains(" ")) {
            throw IllegalArgumentException("Car name '$name' contains spaces in-between which is not allowed")
        }
    }

    // Validate a single car name with all rules
    fun validate(carName: String) {
        validateNotNullOrBlank(carName)
        validateCarName(carName)
        validateLength(carName)
    }

    // Validate the list of car names
    fun validateAll(carNames: List<String>) {
        carNames.forEach { name ->
            validate(name)
        }
    }
}