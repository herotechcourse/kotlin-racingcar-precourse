package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.InputView

class GameController {
    fun start() {
        val carNames = InputView.readCarNames()
        val rounds = InputView.readRound()

        val cars = Cars.from(carNames)
    }
}