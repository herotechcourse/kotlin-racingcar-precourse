package racingcar.controller

import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    fun play() {
        val names=InputView.enterCarNames()
        val roundCount=InputView.enterRoundCount()
        val cars=Cars(names)

        OutputView.printRaceIntro()

        repeat(roundCount){
            cars.moveAll()
            OutputView.printRoundResult(cars.getAll())
        }

        val winners=cars.findWinners()
        OutputView.printWinners(winners)
    }
}