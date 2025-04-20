package racingcar.service

import racingcar.view.OutputView

class RacingGame(private val cars: List<Car>, private val rounds: Int) {
    fun startRace() {
        OutputView.printRaceIntro()
        repeat(rounds) {
            cars.forEach { it.move() }
            OutputView.printRoundResult(cars)
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
            .map { it.name }
    }
}
