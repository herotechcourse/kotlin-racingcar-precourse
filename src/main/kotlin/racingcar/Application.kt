package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNames = InputView.readCarNames()
    val roundNumber = InputView.readRoundNumber()

    val game = RacingGame(carNames)

    println("\nRace Results")

    repeat(roundNumber) {
        game.playRound()
        ResultView.printRound(game.cars)
    }

    ResultView.printWinners(game.findWinners())
}
