package racingcar.controller

import racingcar.model.Car
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
        val cars = carNames.map { Car(it) }

        resultView.printResultHeader()
        repeat(carRounds) { runRounds(cars) }
        val maxProgress = cars.maxByOrNull { it.progress }?.progress
        val carWinner = cars.filter { it.progress == maxProgress }.joinToString(", ") { it.carName }
        resultView.printResultWinner(carWinner)

    }

    private fun runRounds(cars: List<Car>) {
        cars.forEach {
            it.moveForward()
            resultView.printResultRounds(it)
        }
        println()
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