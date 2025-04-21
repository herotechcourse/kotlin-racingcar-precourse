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

/**
 * Not in the task requirements, but was added by my decision.
 */
fun validateDuplicates(names: List<String>) {
    if (names.size != names.toSet().size) {
        throw IllegalArgumentException("The names should be unique.")
    }
}

/**
 * Not in the task requirements, but was added by my decision.
 */
fun validateAllowedCharacters(name: String){
    val regex = Regex("^[a-zA-Z0-9]+$")
    if(!regex.matches(name)){
        throw IllegalArgumentException("The name should contain only letters and numbers")
    }
}
