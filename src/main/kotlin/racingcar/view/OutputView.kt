package racingcar.view

import racingcar.model.Referee
import racingcar.model.Round

class OutputView {
    fun printCarNamesQuestion() {
        println("Enter the names of the cars (comma-separated):")
    }

    fun printTryCountQuestion() {
        println("How many rounds will be played?")
    }

    fun printRoundResultTitle() {
        println("Race Results")
    }

    fun printRoundResult(round: Round) {
        val roundResultForOutput = RoundResultDto.of(round).roundResultForOutput
        roundResultForOutput.map { println(it) }
    }

    fun printWinners(referee: Referee) {
        println("Winners : " + WinnersDto.of(referee).winnersForOutput)
    }
}