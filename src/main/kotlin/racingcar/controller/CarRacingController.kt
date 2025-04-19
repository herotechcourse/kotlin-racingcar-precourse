package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.validator.CarNamesValidator
import racingcar.validator.TotalRoundValidator
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRacingController {
    fun run() {
        val carNames = InputView.getCarNames()
        CarNamesValidator.validate(carNames)

        val totalRound = InputView.getTotalRound()
        TotalRoundValidator.validate(totalRound)

        val race = Race(Car.fromNames(carNames), totalRound.toInt())
        race.runRace()

        OutputView.showAllRoundResult(race)
        OutputView.announceWinner(race.getWinner())
    }
}