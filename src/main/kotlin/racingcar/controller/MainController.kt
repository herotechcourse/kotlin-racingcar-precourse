package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.findTheWinnersIndex

fun mainController() {
    val splitCarNames = InputView().inputCarNames()
    val theNumberOfRounds = InputView().inputTheNumberOfRounds()
    OutputView().printCarRacingStartMessage()

    val finalResultPregressList = OutputView().printCarNamesAndProcess(splitCarNames, theNumberOfRounds)
    val maxIntIndex = findTheWinnersIndex(finalResultPregressList)
    OutputView().printWinners(splitCarNames, maxIntIndex)
}



