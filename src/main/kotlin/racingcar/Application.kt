package racingcar

import racingcar.controller.RacingGame
import racingcar.view.InputView

fun main() {

    val carNames = InputView.readCarNames()
    val roundCount = InputView.readNumOfRounds()

    val game = RacingGame(carNames, roundCount)
    game.play()
}
