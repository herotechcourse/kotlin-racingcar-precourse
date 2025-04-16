package racingcar.view

class OutputView {

    fun printIntroInputCarNamesMessage() {
        println(INTRO_INPUT_CARNAMES_MESSAGE)
    }

    fun printAskPlayRoundPrompt() {
        println(ASK_PLAY_ROUND_PROMPT)
    }

    companion object {
        private val INTRO_INPUT_CARNAMES_MESSAGE = "Enter the names of the cars (comma-separated):"
        private val ASK_PLAY_ROUND_PROMPT = "How many rounds will be played?"
    }
}