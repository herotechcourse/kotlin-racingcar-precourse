package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingCarController(
        inputView = InputView(),
        outputView = OutputView(),
        racingCar = RacingCar()
    ).run()
}
