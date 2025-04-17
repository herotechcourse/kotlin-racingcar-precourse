package racingcar.view

import racingcar.model.Referee
import racingcar.model.Round

class OutputView {

    fun printRoundResult(round: Round) {
        val roundResultForOutput = RoundResultDto.of(round).roundResultForOutput
        roundResultForOutput.map { println(it) }
    }

    fun printWinners(referee: Referee) {
        println("Winners : " + WinnersDto.of(referee).winnersForOutput)
    }
}