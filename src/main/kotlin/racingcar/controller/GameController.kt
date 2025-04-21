package racingcar.controller

import racingcar.model.Car
import racingcar.service.RoundHandler
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun start() {
        val carNames = inputView.readCarNames()
        val roundCount = inputView.readRoundCount()
        
        val cars = createCars(carNames)
        val roundHandler = RoundHandler(cars, outputView)
        
        roundHandler.executeRace(roundCount)
    }
    
    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.mapIndexed { index, name ->
            Car(index + 1, name)
        }
    }
}