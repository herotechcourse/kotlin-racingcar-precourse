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

