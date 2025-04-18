package racingcar.frontend

object OutputView {
    private const val CARS_NAME_INPUT_MESSAGE = "Enter the names of the cars (comma-separated):"
    private const val RACE_COUNT_INPUT_MESSAGE = "How many rounds will be played?"

    fun printCarNamesRequest() = println(CARS_NAME_INPUT_MESSAGE)

    fun printRaceCountRequest() = println(RACE_COUNT_INPUT_MESSAGE)
}