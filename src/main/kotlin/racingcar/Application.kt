package racingcar

import racingcar.controller.CarGameController
import racingcar.view.InputView

fun main() {
    CarGameController(InputView()).run()
}