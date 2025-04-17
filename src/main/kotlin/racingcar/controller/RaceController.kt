package racingcar.controller

import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.strategy.MoveStrategy
import racingcar.strategy.RandomMoveStrategy

class RaceController(
    private val moveStrategy: MoveStrategy = RandomMoveStrategy()
) {
    fun play() {
        val names=InputView.enterCarNames()
        val roundCount=InputView.enterRoundCount()
        val cars=Cars(names)

        OutputView.printRaceIntro()

        repeat(roundCount){
            cars.moveAll(moveStrategy)
            OutputView.printRoundResult(cars.getAll())
        }

        val winners=cars.findWinners()
        OutputView.printWinners(winners)
    }
}