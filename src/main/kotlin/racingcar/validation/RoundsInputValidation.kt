package racingcar.validation

import camp.nextstep.edu.missionutils.Console

// Read input from user
fun readRoundsInput(): String {
    println("Please enter the number of racing rounds:")
    return Console.readLine() ?: ""
}

// 1. Check if the input is a valid integer
fun parseToInteger(input: String): Int {
    return input.toIntOrNull()
        ?: throw IllegalArgumentException("Input must be a valid integer")
}

// 2. Check if the integer is non-negative
fun validateNonNegative(number: Int) {
    if (number <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0")
    }
}

// Process Input
fun processRoundsInput(input: String): Int {
    val number = parseToInteger(input)
    validateNonNegative(number)
    return number
}