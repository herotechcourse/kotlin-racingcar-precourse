package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.InputView

class GameController {
    fun start() {
        val carNames = InputView.readCarNames()
        val cars = Cars.from(carNames)

        val round = InputView.readRound()
    }
}