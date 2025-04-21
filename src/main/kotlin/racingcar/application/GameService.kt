package racingcar.application

import racingcar.domain.Cars
import racingcar.domain.RacingGame
import racingcar.domain.RandomMoveStrategy
import racingcar.domain.Round
import racingcar.presentation.InputView
import racingcar.presentation.OutputView

object GameService {
    fun run() {
        val names = InputView.readCarNames()
        val rawRound = InputView.readRounds()

        val cars = Cars(names)
        val round = Round(rawRound)
        val moveStrategy = RandomMoveStrategy();

        val roundPositions = RacingGame(cars, round, moveStrategy).play()

        OutputView.printPlay(roundPositions)
    }
}