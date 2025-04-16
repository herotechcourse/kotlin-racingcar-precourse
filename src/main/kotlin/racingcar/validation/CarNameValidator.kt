package racingcar.validation

object CarNameValidator {

    // Define Maximum length of Car Names
    private const val MAX_LENGTH = 5

    // 1. Data Validation - Must Have Value
    private fun validateNotNullOrBlank(carName: String?) {
        if (carName.isNullOrBlank()) {
            throw IllegalArgumentException("Car name cannot be null or blank")
        }
    }

    // 2. Data Validation - Exceed Maximum Length
    private fun validateLength(carName: String) {
        if (carName.length > MAX_LENGTH) {
            throw IllegalArgumentException("Car name '$carName' exceeds max length of $MAX_LENGTH.")
        }
    }

    // Call Data Validation Functions
    fun validate(carName: String) {
        validateNotNullOrBlank(carName)
        validateLength(carName)
    }

    // Validate the list of car names
    fun validateAll(carNames: List<String>) {
        carNames.forEach { name ->
            validate(name)
        }
    }
}