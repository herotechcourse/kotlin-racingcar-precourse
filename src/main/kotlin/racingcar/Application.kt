package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.service.Car
import racingcar.service.RacingGame


fun main() {
    val carNames = InputView.readCarNames()
    val roundCount = InputView.readRoundCount()

    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars, roundCount)

    game.startRace()

    val winners = game.getWinners()
    OutputView.printWinners(winners)
}
