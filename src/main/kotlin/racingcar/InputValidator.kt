package racingcar

object InputValidator {

    fun validateCarName(name: String): String {
        if (name.length > 5) {
            throw IllegalArgumentException("Car name length is over 5: $name")
        }
        if (name.isBlank()) {
            throw IllegalArgumentException("Empty car name is contained")
        }
        return name.trim()
    }

    fun validateRoundNumber(input: String?): Int {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("The input must not be blank")
        }

        val number = input.toIntOrNull() ?: throw IllegalArgumentException("The input is not a valid integer")

        if (number <= 0) {
            throw IllegalArgumentException("The input must be a positive integer")
        }

        return number
    }
}
