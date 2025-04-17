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

    fun readValidCarName(): String {
        val carNames = inputView.readCarName()
        validator.validateCarName(carNames)
        return carNames
    }

    fun readValidRounds(): Int {
        val rounds = inputView.readRounds()
        return validator.validateRounds(rounds)
    }
}