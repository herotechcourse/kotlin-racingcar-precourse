package racingcar.controller

import racingcar.model.Car
import racingcar.util.InputParser
import racingcar.util.InputValidator
import racingcar.util.WinnerFinder
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGame {

    private lateinit var cars: List<Car>
    private var roundCount: Int = 0

    fun init() {
        val carNamesInput = InputView.inputCarName()
        val carNames = InputParser.parseCarNames(carNamesInput)
        InputValidator.validateCarNames(carNames)
        cars = carNames.map { Car(it) }

        val roundInput = InputView.inputRoundCount()
        roundCount = InputValidator.validateRoundCount(roundInput)
    }

    fun play() {
        println("Race Results")
        repeat(roundCount) {
            cars.forEach { it.move() }
            OutputView.printRoundResult(cars)
        }
    }

    fun showWinners() {
        val winners = WinnerFinder.findWinners(cars)
        OutputView.printWinners(winners)
    }
}