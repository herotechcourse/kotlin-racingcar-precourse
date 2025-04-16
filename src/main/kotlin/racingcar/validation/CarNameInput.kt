package racingcar.validation

import camp.nextstep.edu.missionutils.Console

fun readUserInput(): String {
    // Function to read input data
    println("Please enter car names (separated by commas):")
    return Console.readLine() ?: ""
}

fun validateSeparator(input: String) {
    // Check for any Illegal Characters
    if (input.contains(Regex("[^a-zA-Z0-9, ]"))) {
        throw IllegalArgumentException("Invalid character detected")
    }
}

fun validateCarName(name: String) {
    // Check if the car name contains space internally after split
    if (name.contains(" ")) {
        throw IllegalArgumentException("Car name '$name' contains spaces in-between which is not allowed")
    }
}

fun splitAndTrimInput(input: String): List<String> {
    // Split input by commas and trim spaces
    val carNames = input.split(',')
        .map { it.trim() }

    // Validate each car name to ensure there are no internal spaces
    carNames.forEach { validateCarName(it) }

    return carNames
}

fun processUserInput(input: String): List<String> {
    // Validate the separators
    validateSeparator(input)

    return splitAndTrimInput(input)
}
