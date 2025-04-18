package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.OutputRaceProgress

class GameController (
    private val cars: Cars,
    private val roundCount: Int
) {
    fun startGame() {
        repeat(roundCount) {
            startTurn()
        }
    }
    private fun startTurn() {
        cars.raceOnce() // Race the car once
        OutputRaceProgress.showRace(cars) // Print the results of one round
    }
}