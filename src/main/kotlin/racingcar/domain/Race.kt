package racingcar.domain

import racingcar.car.Car
import racingcar.ui.InputView
import racingcar.ui.OutputView

class Race (
    private val inputView: InputView,
    private val outputView: OutputView,
    private val winner: Winner
){
    fun run(){
        val cars:List<Car> = inputView.getCars()
        val rounds = inputView.getRounds()
        outputView.printRaceStartMessage()
        for (i in 0 until rounds) {
            for (car in cars) {
                car.drive()
            }
            outputView.printCarsAndPositions(cars)
        }
        outputView.printWinners(winner.determineWinners(cars))
    }
}