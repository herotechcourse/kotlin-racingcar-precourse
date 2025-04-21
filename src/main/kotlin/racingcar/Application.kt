package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.RacingCarGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingCarController(
        inputView = InputView(),
        outputView = OutputView(),
        racingCarGame = RacingCarGame()
    ).run()
}
