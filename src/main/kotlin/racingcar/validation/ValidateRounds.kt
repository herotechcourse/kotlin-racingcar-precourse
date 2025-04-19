package racingcar.validation

/**
 *  [ Condition ]
 *  1. Empty            //  ""
 *  2. Non-digit chars  //  3a
 *  3. Zero             //  0
 *  4. Negative number  //  -7
 */
fun isZero(input: String): Boolean {
    return input == "0"
}

fun isNegative(input: String): Boolean {
    val strToInt = input.toIntOrNull()
    if (strToInt == null) {
        return false
    }
    return strToInt < 0
}

fun isNonDigit(input: String): Boolean {
    return input.toIntOrNull() == null
}

fun isEmpty(input: String): Boolean {
    return input.isBlank()
}

fun isValidRounds(input: String): Boolean {
    return !(isEmpty(input) || isNonDigit(input) || isZero(input) || isNegative(input))
}

fun validateRounds(input: String): {
    if (!isValidRounds(input)) {
        throw IllegalArgumentException("Rounds must be a positive number(Type: Int)")
    }
}