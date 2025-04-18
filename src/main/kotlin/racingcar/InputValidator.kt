package racingcar

fun validateCarNames(names: List<String>) {
    names.forEach { name ->
        if (name.isBlank()) {
            throw IllegalArgumentException("Car names cannot be blank.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car names must be 5 characters or fewer.")
        }
    }
}

fun validateRoundCount(input: String): Int {
    val rounds = input.toIntOrNull()
        ?: throw IllegalArgumentException("Rounds must be a valid number.")
    if (rounds <= 0) {
        throw IllegalArgumentException("Rounds must be greater than 0.")
    }
    return rounds
}
