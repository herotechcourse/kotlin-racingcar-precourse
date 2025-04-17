package racingcar.view

class ConsoleOutputView : OutputView {

    override fun printCarNamesPrompt() {
        println(INPUT_CARNAME_MESSAGE)
    }

    override fun printRoundCountPrompt() {
        println(INPUT_ROUND_MESSAGE)
    }

    override fun printRaceResultPrompt() {
        println(ROUND_RESULT_INTRO_MESSAGE)
    }

    override fun printProgress(message: List<String>) {
        message.forEach(::println)
        println()
    }

    override fun printWinners(message: String) {
        println(message)
    }

    companion object {
        private const val INPUT_CARNAME_MESSAGE = "Enter the names of the cars (comma-separated):"
        private const val INPUT_ROUND_MESSAGE = "How many rounds will be played?"
        private const val ROUND_RESULT_INTRO_MESSAGE = "Race Results"
    }
}
