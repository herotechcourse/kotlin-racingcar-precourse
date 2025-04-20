package racingcar

fun validateCarNames(inputString: String): List<String> {
    if (inputString.isBlank())
        throw IllegalArgumentException()
    val carNames = inputString.split(",").map {
        it.trim()
    }
    carNames.forEach { name ->
        if (name.isBlank() || name.length > 5) {
            throw IllegalArgumentException()
        }
    }
    return carNames
}

fun validateNumberOfRounds(inputString: String): Int {
    val numberOfRounds: Int
    try {
        numberOfRounds = inputString.toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException()
    }
    if (numberOfRounds < 0) {
        throw IllegalArgumentException()
    }
    return numberOfRounds
}
