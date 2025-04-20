package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val controller = RacingCarController(
        InputView(),
        OutputView(),
    )
    controller.start()
}
