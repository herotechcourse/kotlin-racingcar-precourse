package racingcar

fun validateRounds(rounds: Int) {
    if (rounds <= 0) {
        throw IllegalArgumentException("The number of rounds cannot be zero or less.")
    }
}

fun validateNameLength(name: String) {
    if (name.length > 5) {
        throw IllegalArgumentException("The name must not exceed 5 characters.")
    }
}

fun validateEmptyName(name: String) {
    if (name.isEmpty()) {
        throw IllegalArgumentException("The name must not be an empty string.")
    }
}

fun validateDuplicates(names: List<String>) {
    if (names.size != names.toSet().size) {
        throw IllegalArgumentException("The names should be unique.")
    }
}