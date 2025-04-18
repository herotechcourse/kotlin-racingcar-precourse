package racingcar.controller

import racingcar.domain.Car
import racingcar.service.RacingGameService
import racingcar.view.InputView
import racingcar.view.ResultView

object GameController {
    fun run() {
        val carNames = InputView.readCarNames()
        val cars = carNames.map { Car(it) }

        val roundCount = InputView.readRoundCount()
        val gameService = RacingGameService(cars)

        ResultView.printResultHeader()
        gameService.play(roundCount).forEach { roundResult ->
            ResultView.printRound(roundResult)
        }

        val winners = gameService.getWinners()
        ResultView.printWinners(winners)
    }
}
