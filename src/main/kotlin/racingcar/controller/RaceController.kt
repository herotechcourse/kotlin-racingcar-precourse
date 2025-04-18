package racingcar.controller

import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    fun run() {
        val carNames = InputView.readCarNames()
        val numberOfRounds = InputView.readNumberOfRounds()

        println()

        val race = Race(carNames)

        println("Race Results")
        repeat(numberOfRounds) {
            race.playRound()
            OutputView.printRoundResult(race.cars)
        }

        val winners = race.getWinners()
        OutputView.printWinners(winners)
    }
}