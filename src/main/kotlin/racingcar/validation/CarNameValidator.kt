package racingcar.validation

private const val MAX_NAME_LENGTH = 5;

fun validateCarName(name: String) {
    if (isValidLength(name))
        throw IllegalArgumentException("Car name must be between 1 and 5 characters.");
}

fun isValidLength(name: String): Boolean {
    return name.length in 1 .. MAX_NAME_LENGTH;
}
