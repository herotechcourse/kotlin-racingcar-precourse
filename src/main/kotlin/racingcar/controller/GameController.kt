package racingcar.controller

import racingcar.domain.Cars
import racingcar.service.OutputService
import racingcar.view.OutputRaceProgress
import racingcar.view.OutputResult

class GameController (
    private val cars: Cars,
    private val roundCount: Int,
    private val outputService: OutputService
) {
    fun startGame() {
        println("Race Results")
        repeat(roundCount) {
            startTurn()
        }
        OutputResult.showResult(cars)
    }
    private fun startTurn() {
        cars.raceOnce() // Race the car once
        OutputRaceProgress.showRace(cars) // Print the results of one round
    }
}