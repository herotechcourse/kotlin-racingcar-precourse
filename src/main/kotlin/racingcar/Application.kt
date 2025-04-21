package racingcar

import racingcar.controller.RacingController
import racingcar.utils.InputValidatorImpl
import racingcar.view.InputViewImpl
import racingcar.view.ResultViewImpl

fun main() {
    val inputView = InputViewImpl()
    val resultView = ResultViewImpl()
    val validator = InputValidatorImpl()
    val controller = RacingController(inputView, resultView, validator)

    controller.run()
}
