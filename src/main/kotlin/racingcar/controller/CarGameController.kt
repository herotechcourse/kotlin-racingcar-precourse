package racingcar

import racingcar.view.InputView

class CarGameController(
  private val inputView : InputView
) {
  fun run() {
    val carNames = inputView.readCarNames()
    val rounds = inputView.readRounds()
  }
}
