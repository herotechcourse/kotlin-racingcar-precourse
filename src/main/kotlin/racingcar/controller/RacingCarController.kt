package racingcar.controller

import racingcar.view.InputView

class RacingCarController(
    private val inputView: InputView,
) {
    fun start() {
        val cars = inputView.receiveCarNamesInput()
        val numberOfRounds = inputView.receiveNumberOfRounds()
    }
}
