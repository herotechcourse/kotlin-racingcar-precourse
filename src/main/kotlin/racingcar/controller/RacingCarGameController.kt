package racingcar.controller

import racingcar.view.InputView

class RacingCarGameController(
    private val inputView: InputView
) {
    fun run() {
        val carNames = inputView.readCarNames()
        val rounds = inputView.readNumberOfRounds()
    }
}