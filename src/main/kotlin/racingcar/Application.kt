package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.InputView

fun main() {
    val controller = RacingCarController(
        InputView(),
    )
    controller.start()
}
