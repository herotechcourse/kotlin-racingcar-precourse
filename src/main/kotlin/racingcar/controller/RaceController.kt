package racingcar.controller

import racingcar.model.*
import racingcar.view.CarNameDto
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.view.TryCountDto

class RaceController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val fuel: Fuel = RandomNumberGenerator()

    fun start() {
        outputView.printCarNamesQuestion()
        val inputCarNames = inputView.inputCarNames()
        outputView.printTryCountQuestion()
        val inputTryCount = inputView.inputTryCount()

        val participants = makeParticipants(inputCarNames)

        startRace(inputTryCount, participants)
        startJudge(participants);
    }

    private fun makeParticipants(inputCarNames: List<CarNameDto>): List<Car> {
        return inputCarNames.map { it ->
            Car(
                it.name, fuel = fuel
            )
        }.toList()
    }

    private fun startRace(inputTryCount: TryCountDto, participants: List<Car>) {
        outputView.printRoundResultTitle()
        for (i: Int in 1..inputTryCount.count) {
            val round = Round(i, participants)
            round.race()
            outputView.printRoundResult(round)
            println()
        }
    }

    private fun startJudge(participants: List<Car>) {
        val referee = Referee(participants)
        referee.judge()
        outputView.printWinners(referee)
    }
}
