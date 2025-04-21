package racingcar.controller

import racingcar.model.findWinners
import racingcar.model.makeRacingProgressList
import racingcar.view.InputView
import racingcar.view.OutputView

object MainController {
    fun run() {
        val carNames = InputView.getCarNamesInput()
        val racingRounds = InputView.getRacingRoundsInput()

        val progressList = makeRacingProgressList(carNames, racingRounds)
        OutputView.printRacingStartMessage()
        OutputView.printCarNamesAndProcess(carNames, progressList)

        val winners = findWinners(carNames, progressList)
        OutputView.printWinners(winners)
    }
}
