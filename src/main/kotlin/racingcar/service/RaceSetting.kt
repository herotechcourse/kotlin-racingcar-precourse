package racingcar.service

import racingcar.domain.RacingCars
import racingcar.view.InputHandler
import racingcar.view.OutputView

object RaceSetting {

    fun run() {
        val carNames = InputHandler.readCarNames()
        val numberOfRounds = InputHandler.readNumberOfRounds()
        val racingCars = RacingCars.fromNames(carNames)

        OutputView.printRaceStart()
        repeat(numberOfRounds) {
            racingCars.moveAll()
            OutputView.printRound(racingCars)
        }

        val winners = racingCars.getWinners()
        OutputView.printWinners(winners)
    }
}
