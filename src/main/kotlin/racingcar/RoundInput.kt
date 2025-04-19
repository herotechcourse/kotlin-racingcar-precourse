package racingcar

fun parseRoundInput(input: String): Int {
    if (input.isBlank()) {
        throw IllegalArgumentException("Round input cannot be blank.")
    }
    return try {
        input.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Round input must be a valid number.")
    }
}

fun validateRoundNum(number: Int) {
    if (number <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than zero.")
    }
    if (number >= 100) {
        throw IllegalArgumentException("Number of rounds must be less than 100.")
    }
}