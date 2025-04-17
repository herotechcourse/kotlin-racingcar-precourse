package racingcar.view

interface OutputView {
    fun printCarNamesPrompt()
    fun printRoundCountPrompt()
    fun printRaceResultPrompt()
    fun printProgress(message: List<String>)
    fun printWinners(message: String)
}