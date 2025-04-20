package racingcar.input.util

private const val SEPARATOR = ",";
fun getCarNamesFromInput(input: String): Array<String> {
    return input.split(SEPARATOR).toTypedArray()
}