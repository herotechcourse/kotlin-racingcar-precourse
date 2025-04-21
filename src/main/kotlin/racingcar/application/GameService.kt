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
        val racingGame = RacingGame(cars, round, moveStrategy)

        val roundPositions = racingGame.play()
        OutputView.printPlay(roundPositions)

        val winners = racingGame.getWinners()
        OutputView.printWinners(winners)
    }
}