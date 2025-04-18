package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.findTheWinnersIndex

// TO-DO: Refactor / move to mainController
fun main() {
    val splitCarNames = InputView().inputCarNames()
    val theNumberOfRounds = InputView().inputTheNumberOfRounds()
    OutputView().printCarRacingStartMessage()

    val finalResultPregressList = OutputView().printCarNamesAndProcess(splitCarNames, theNumberOfRounds)
    val maxIntIndex = findTheWinnersIndex(finalResultPregressList)
}



