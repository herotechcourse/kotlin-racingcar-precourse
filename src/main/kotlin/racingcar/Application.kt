package racingcar

import racingcar.controller.RacingGameController
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val controller = RacingGameController(inputView, resultView)

    controller.race()
}
