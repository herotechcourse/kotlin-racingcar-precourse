package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRacingController {
    fun run() {
        val carNames = InputView.getCarNames()
        val totalRound = InputView.getTotalRound()

        val race = Race(Car.fromNames(carNames), totalRound)
        race.runRace()

        OutputView.showAllRoundResult(race)
        OutputView.announceWinner(race.getWinner())
    }
}