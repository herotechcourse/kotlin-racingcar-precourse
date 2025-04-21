package racingcar.controller

import racingcar.model.Car
import racingcar.model.findWinner
import racingcar.utils.InputValidator
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingController(
    private val inputView: InputView,
    private val resultView: ResultView,
    private val validator: InputValidator,
) {
    fun run() {
        val carNames = readValidCarName()
        val carRounds = readValidRounds()
        val cars: List<Car> = carNames.map { Car(it) }

        resultView.printResultHeader()
        repeat(carRounds) { runRounds(cars) }
        resultView.printResultWinner(cars.findWinner())

    }

    private fun runRounds(cars: List<Car>) {
        cars.forEach {
            it.moveForward()
            resultView.printResultRounds(it)
        }
        resultView.printNewLine()
    }

    private fun readValidCarName(): List<String> {
        val carNames = inputView.readCarName()
        return validator.validateCarName(carNames)
    }

    private fun readValidRounds(): Int {
        val rounds = inputView.readRounds()
        return validator.validateRounds(rounds)
    }
}