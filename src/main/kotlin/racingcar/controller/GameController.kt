package racingcar.controller

import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.ResultView

class GameController {
    fun play() {
        val carNames = InputView.readCarNames()
        val roundCount = InputView.readRoundCount()
        val race = Race(carNames)

        println("\nRace Results")

        repeat(roundCount) {
            race.moveAllCars()
            ResultView.printRoundResult(race.cars)
        }

        ResultView.printWinners(race.findWinners())
    }
}
