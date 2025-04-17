package racingcar.input

fun processUserInput(input: String): List<String> {
    return input.split(',')
        .map { it.trim() }
}