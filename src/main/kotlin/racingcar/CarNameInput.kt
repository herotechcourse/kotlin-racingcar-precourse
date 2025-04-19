package racingcar

fun splitCarNames(input: String): List<String> {
    if (input.isBlank()) {
        throw IllegalArgumentException("Car name input cannot be blank.")
    }
    return input.split(",").map { it.trim() }
}

fun validateCarNames(carNames: List<String>) {
    if (carNames.any { it.isBlank() }) {
        throw IllegalArgumentException("Car names cannot be blank.")
    }
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be 5 characters or fewer.")
    }
    if (carNames.size != carNames.toSet().size) {
        throw IllegalArgumentException("Car names must be unique.")
    }
}
