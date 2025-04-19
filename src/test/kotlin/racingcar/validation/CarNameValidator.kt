package racingcar.validation

private const val MIN_NAME_LENGTH = 1;
private const val MAX_NAME_LENGTH = 5;

fun isValidCarName(name: String): Boolean {
    return name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH;
}