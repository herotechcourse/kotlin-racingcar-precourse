package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.util.RandomGenerator
import racingcar.view.ResultView

class RacingGame(
    carNames: List<String>,
    private val roundCnt: Int
) {
    private var cars = Cars(carNames.map { Car(it) })

    fun play() {
        repeat(roundCnt) {
            cars.moveAll { RandomGenerator.generate() }
            ResultView.printRoundResult(cars.getPositions())
        }

        val winners = cars.findWinners()
        ResultView.printWinners(winners)
    }
}