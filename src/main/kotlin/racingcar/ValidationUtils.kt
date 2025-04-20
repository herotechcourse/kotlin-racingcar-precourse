package racingcar

fun validateRounds(rounds: Int?) {
    if (rounds == null || rounds <= 0) {
        throw IllegalArgumentException("The number of rounds cannot be zero or less.")
    }
}

fun validateNamesLength(name: String) {
    if (name.length > 5) {
        throw IllegalArgumentException("The name must be less than 5 characters.")
    }
}

fun validateEmptyNames(name: String) {
    if (name.isEmpty()) {
        throw IllegalArgumentException("The name must not be an empty string.")
    }
}