package racingcar.view

class OutputView {

    fun printCarNamesPrompt() {
        println(CAR_NAME_PROMPT)
    }

    fun printRoundCountPrompt() {
        println(ROUND_COUNT_PROMPT)
    }

    fun printRaceResultPrompt() {
        println(RACE_RESULT_PROMPT)
    }

    fun printProgress(lines: List<String>) {
        lines.forEach { println(it) }
        println()
    }

    companion object {
        private const val CAR_NAME_PROMPT = "Enter the names of the cars (comma-separated):"
        private const val ROUND_COUNT_PROMPT = "How many rounds will be played?"
        private const val RACE_RESULT_PROMPT = "Race Results"
    }
}