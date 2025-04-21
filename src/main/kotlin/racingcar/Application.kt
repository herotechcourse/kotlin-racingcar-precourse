package racingcar

import racingcar.controller.Controller
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    Controller(inputView, outputView).run()
}
