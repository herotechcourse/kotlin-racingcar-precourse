package racingcar

import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController {

    fun run() {
        val cars = InputView.readCars()
        val count = InputView.readCount()
        OutputView.showRacing(cars)
        startRacingGame(count, cars)
        OutputView.showResult(cars.getWinners())
    }

    private fun startRacingGame(count: Int, cars: Cars) {
        repeat(count) {
            cars.moveAll()
            cars.showAll()
        }
    }
}