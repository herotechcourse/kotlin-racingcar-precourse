package racingcar.controller

import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val fuel: Fuel = RandomNumberGenerator()

    fun start() {
        outputView.printCarNamesQuestion()
        val inputCarNames = inputView.inputCarNames()
        outputView.printTryCountQuestion()
        val inputTryCount = inputView.inputTryCount()
        println()
        val participants = inputCarNames.map { it ->
            Car(
                it.name, fuel = fuel
            )
        }.toList()
        outputView.printRoundResultTitle()
        for (i: Int in 1..inputTryCount.count) {
            val round = Round(i, participants)
            round.race()
            outputView.printRoundResult(round)
            println()
        }
        val referee = Referee(participants)
        referee.judge()
        outputView.printWinners(referee)
    }
}