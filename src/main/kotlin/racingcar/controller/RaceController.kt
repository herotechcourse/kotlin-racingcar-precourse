package racingcar.controller

import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.strategy.move.MoveStrategy
import racingcar.strategy.move.RandomMoveStrategy
import racingcar.strategy.winner.WinnerStrategy
import racingcar.strategy.winner.MaxPositionStrategy


class RaceController(
    private val moveStrategy: MoveStrategy = RandomMoveStrategy(),
    private val winnerStrategy: WinnerStrategy = MaxPositionStrategy()
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

        val winners=cars.findWinners(winnerStrategy)
        OutputView.printWinners(winners)
    }
}