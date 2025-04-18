package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.findTheWinners
import racingcar.model.makeRacingProgressList

fun mainController() {
    // TO-DO: Refactor rename (splitCarNames -> carNames)
    val splitCarNames = InputView().inputCarNames()
    val theNumberOfRounds = InputView().inputTheNumberOfRounds()

    val progressList = makeRacingProgressList(splitCarNames, theNumberOfRounds)
    OutputView().printRacingStartMessage()

    OutputView().printCarNamesAndProcess(splitCarNames, progressList)

    val winners = findTheWinners(splitCarNames, progressList)
    OutputView().printWinners(winners)
}
