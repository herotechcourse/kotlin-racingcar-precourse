package racingcar.validation

/**
 * Utility class to validate car names according to business rules:
 * - At least one car is required
 * - No blank names
 * - No name longer than 5 characters
 * - No duplicate names
 */
object CarNameValidator {
    fun validate(names: List<String>): List<String> {
        require(names.isNotEmpty()) { "At least one car must be entered." }
        names.forEach {
            require(it.isNotBlank()) { "Car name cannot be blank." }
            require(it.length <= 5) { "Car name cannot exceed 5 characters: $it" }
        }
        require(names.size == names.toSet().size) { "Duplicate car names are not allowed." }
        return names
    }
}
