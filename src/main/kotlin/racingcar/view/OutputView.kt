package racingcar.view

class OutputView {

    fun printCarNamesPrompt() {
        println(CAR_NAME_PROMPT)
    }

    fun printRoundCountPrompt() {
        println(ROUND_COUNT_PROMPT)
    }

    companion object {
        private val CAR_NAME_PROMPT = "Enter the names of the cars (comma-separated):"
        private val ROUND_COUNT_PROMPT = "How many rounds will be played?"
    }
}