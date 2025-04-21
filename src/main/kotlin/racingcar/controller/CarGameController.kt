package racingcar

import racingcar.view.InputView

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
