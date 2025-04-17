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

//fun main () {
//    val testCases = listOf("0", "-7", "3a", "", "1", "11", "111")
//
//    for (input in testCases) {
//        println("Input: \"$input\"")
//        if (isValidRounds(input)) {
//            println("KO")
//        }
//        else
//            println("OK")
//        println("\n")
//    }
//}