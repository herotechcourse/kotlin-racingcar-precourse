package racingcar.validation

private const val MIN_NAME_LENGTH = 1;
private const val MAX_NAME_LENGTH = 5;

fun isNaturalNumber(num: Int): Boolean {
    return num >= 1;
}