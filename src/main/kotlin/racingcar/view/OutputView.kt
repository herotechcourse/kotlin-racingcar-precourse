package racingcar.view

import racingcar.model.Round

class OutputView {

    fun printRoundResult(round: Round) {
        val roundResultForOutput = RoundResultDto(round).getRoundResultForOutput()
        roundResultForOutput.map { println(it) }
    }
}