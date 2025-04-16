package racingcar.domain

import racingcar.car.Car
import racingcar.ui.OutputView

class Race {
    val outputView = OutputView()
    val winner = Winner()
    fun race(cars: List<Car>, attempts: Int){
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