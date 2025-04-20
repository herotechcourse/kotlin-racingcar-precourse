package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.model.findWinners
import racingcar.model.makeRacingProgressList

fun mainController() {
    val carNames = InputView.getCarNamesInput()
    val racingRounds = InputView.getRacingRoundsInput()

    val progressList = makeRacingProgressList(carNames, racingRounds)
    OutputView.printRacingStartMessage()
    OutputView.printCarNamesAndProcess(carNames, progressList)

    val winners = findWinners(carNames, progressList)
    OutputView.printWinners(winners)
}
