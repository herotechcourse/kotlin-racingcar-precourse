package racingcar.validator

private const val MIN_NAME_LENGTH = 5

class CarNamesValidator : InputValidator<List<String>> {
    override fun validate(raw: String): List<String> {
        val names = raw.split(",").map { it.trim() }
        require(names.isNotEmpty()) { "Please enter at least one car name." }
        require(names.all { it.isNotBlank() && it.length <= MIN_NAME_LENGTH }) {
            "Car names must be non‑empty and ≤ $MIN_NAME_LENGTH characters."
        }
        return names
    }
}