package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

// TO-DO: Refactor / move to mainController
fun main() {
    val splitCarNames = InputView().inputCarNames()
    val theNumberOfRounds = InputView().inputTheNumberOfRounds()

    OutputView().printCarRacingStartMessage()
    OutputView().printCarNamesAndProcess(splitCarNames, theNumberOfRounds)
}
