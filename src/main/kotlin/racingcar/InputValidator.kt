package racingcar

fun getCarNames(userInput: String): List<String> {
    if (userInput.isBlank()) {
        throw IllegalArgumentException("Car names should be given.")
    }

    val trimmedNames = userInput.split(",").map { it.trim() }
    validateNames(trimmedNames)
    return trimmedNames
}

fun getNumberOfRounds(userInput: String): Int {
    val rounds: Int
    val tempNum = userInput.toIntOrNull()

    if (tempNum != null && tempNum > 0) {
        rounds = tempNum
    } else {
        throw IllegalArgumentException("Number of rounds must be an integer bigger than 0.")
    }

    return rounds
}

fun validateNames(names: List<String>) {
    val uniqueNames = mutableSetOf<String>()

    for (name in names) {
        if (name.length == 0) {
            throw IllegalArgumentException("Car names should not be empty.")
        } else if (name.length > 5) {
            throw IllegalArgumentException("Car names should not have more than 5 characters")
        } else if (!uniqueNames.add(name)) {
            throw IllegalArgumentException("Duplicate car name found: $name")
        }
    }
}