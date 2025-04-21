package racingcar.controller

import racingcar.view.InputView
import racingcar.controller.GameController
import racingcar.model.Car

class CarGameController(private val inputView : InputView) {
  fun run() {
    val carNames = inputView.readCarNames()
    val rounds = inputView.readRounds()

    val game = GameController(carNames, rounds)

    game.startRace()

    val winners = game.getWinners()
    println("Winners : ${winners.joinToString(", ") { it.name }}")

  }
}
