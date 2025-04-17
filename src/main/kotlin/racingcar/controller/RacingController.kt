package racingcar.controller

import racingcar.utils.InputValidator
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val validator: InputValidator,
) {
    fun run() {
    }

    fun readValidCarName(): List<String> {
        val carNames = inputView.readCarName()
        return validator.validateCarName(carNames)
    }

    fun readValidRounds(): Int {
        val rounds = inputView.readRounds()
        return validator.validateRounds(rounds)
    }
}