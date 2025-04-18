package racingcar

import racingcar.frontend.InputView
import racingcar.frontend.OutputView

fun main() {
    OutputView.printCarNamesRequest()
    val carNames = InputView.getCarNames()
}
