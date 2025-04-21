package racingcar

import racingcar.controller.RacingCarGameController
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingCarGameController(InputView(), OutputView()).run()
}
