package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.util.RandomGenerator
import racingcar.view.ResultView

class RacingGame(
    carNames: List<String>,
    private val roundCnt: Int,
    private val random: () -> Int = { RandomGenerator.generate() }
) {
    private var cars = Cars(carNames.map { Car(it) })

    fun play() {
        println("\nRace Results")

        repeat(roundCnt) {
            cars.moveAll { random() }
            ResultView.printRoundResult(cars.getPositions())
        }

        val winners = cars.findWinners()
        ResultView.printWinners(winners)
    }
}