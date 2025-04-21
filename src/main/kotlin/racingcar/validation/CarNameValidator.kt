package racingcar.validation

import racingcar.config.Config

/**
 * Validates comma-separated car names.
 *
 * @param input raw input string
 * @return list of trimmed, validated car names
 * @throws IllegalArgumentException on invalid input
 */
object CarNameValidator : Validator<String, List<String>> {
    override fun validate(input: String): List<String> {
        val names = input.split(",").map { it.trim() }

        require(names.isNotEmpty()) { "At least one car name is required." }
        require(names.size == names.distinct().size) { "Car names must be unique." }
        names.forEach {
            require(it.isNotBlank())                                { "Car name cannot be blank." }
            require(it.all(Char::isLetterOrDigit))        { "Car name '$it' must be alphanumeric." }
            require(it.length <= Config.MAX_CAR_NAME_LENGTH)        { "Car name '$it' exceeds ${Config.MAX_CAR_NAME_LENGTH} characters." }
        }

        return names
    }
}
