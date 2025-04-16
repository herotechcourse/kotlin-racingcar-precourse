package racingcar.domain

import racingcar.car.Car
import racingcar.ui.InputView
import racingcar.ui.OutputView

class Race {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val winner = Winner()
    fun race(){
        val cars:List<Car> = inputView.getCars()
        val attempts = inputView.getAttempts()
        outputView.printRaceStartMessage()
        for (i in 0 until attempts) {
            for (car in cars) {
                car.drive()
            }
            outputView.printCarsAndPositions(cars)
        }
        outputView.printWinners(winner.determineWinners(cars))
    }
}