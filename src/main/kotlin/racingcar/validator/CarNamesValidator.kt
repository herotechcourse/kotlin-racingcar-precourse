package racingcar.validator

class CarNamesValidator : InputValidator<List<String>> {
    override fun validate(raw: String): List<String> {
        val names = raw.split(",").map { it.trim() }
        require(names.isNotEmpty()) { "Please enter at least one car name." }
        require(names.all { it.isNotBlank() && it.length <= 5 }) {
            "Car names must be non‑empty and ≤ 5 characters."
        }
        return names
    }
}