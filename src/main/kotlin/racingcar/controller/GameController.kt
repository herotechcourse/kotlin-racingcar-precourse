package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.Round
import racingcar.view.InputView

class GameController {
    fun start() {
        val carNames = InputView.readCarNames()
        val cars = Cars.from(carNames)

        val round = Round.from(InputView.readRound())
    }
}