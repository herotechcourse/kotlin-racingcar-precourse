package racingcar.controller

import racingcar.view.InputView

class GameController {
    fun start() {
        val carNames = InputView.readCarNames()
    }
}