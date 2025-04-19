package racingcar

import racingcar.controller.RaceController
import racingcar.parser.CarNameParser
import racingcar.parser.RoundsParser
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val carNameParser = CarNameParser
    val roundsParser = RoundsParser

    val inputView = InputView
    val outputView = OutputView

    val controller = RaceController(inputView, outputView, carNameParser, roundsParser)

    controller.start()
}
