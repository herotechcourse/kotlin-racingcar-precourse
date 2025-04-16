package racingcar.view

class OutputView {

    fun printIntroInputCarNamesMessage() {
        println(INTRO_INPUT_CARNAMES_MESSAGE)
    }

    companion object {
        private val INTRO_INPUT_CARNAMES_MESSAGE = "Enter the names of the cars (comma-separated):"
    }
}