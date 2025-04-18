package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView
){
    fun run() {
        val carNamesInput = inputView.readCarNames()
        val roundCountInput = inputView.readNumberOfRounds()

        val carNames = carNamesInput.split(",").map{ it.trim() }
        val carList = carNames.map{ Car(it) }
        val cars = Cars(carList)

        val roundCount = roundCountInput.toInt()

        outputView.printStartMessage()
        val game = RacingGame(cars, roundCount)
        game.start()

        val winners = game.getWinners()
        outputView.printWinners(winners)

    }

}