package racingcar.controller

import racingcar.view.InputView

class GameController {
    fun init(): Unit {
       val carNames = InputView.getCarNames()
       val rounds = InputView.getRounds()
    }
}