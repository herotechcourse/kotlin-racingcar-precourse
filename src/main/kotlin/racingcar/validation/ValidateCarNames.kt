package racingcar.validation

/**
 *  [ Condition ]
 *  1. Not exceed 5 characters.     // "abcdef"
 *  2. Not null or empty (= blank)  // "" or " "
 *  3. Comma-separated format.      // "pobi,woni,jun"
 */
fun isNotExceed5Chars(input: String): Boolean {
    return input.length <= 5
}

fun isNotBlankInput(input: String): Boolean {
    return input.isNotBlank()
}

fun isCommaSeparated(input: String): Boolean {
    val carNames = input.split(",")
    return carNames.all { isNotBlankInput(it) && isNotExceed5Chars(it) }
}

fun isValidCarNames(input: String): Boolean {
    return isCommaSeparated(input) && isNotBlankInput(input)
}

fun validateCarNames(input: String) {
    if (!isValidCarNames(input)) {
        throw IllegalArgumentException("Car names are not valid.")
    }
}