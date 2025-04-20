package racingcar.view

object OutputView {
    private const val RACING_START = "Race Results"
    private const val WINNERS_MESSAGE_PREFIX = "Winners :"
    private fun makeProgressLine(count: Int) {
        "-".repeat(count)
    }

    fun printRacingStartMessage() {
        println("")
        println(RACING_START)
    }

    // TO-DO: Refactor separate for "-"
    fun printCarNamesAndProcess(carNames: List<String>, progressList: List<List<Int>>) {
        progressList.forEach { eachRoundProgress ->
            carNames.withIndex().forEach { (index, carName) ->
                println("$carName : ${makeProgressLine(eachRoundProgress[index])}")
            }
            println("")
        }
    }

    fun printWinners(winners: List<String>) {
        println("$WINNERS_MESSAGE_PREFIX ${winners.joinToString()}")
    }
}

