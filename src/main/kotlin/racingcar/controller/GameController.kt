package racingcar.controller

import racingcar.domain.Cars
import racingcar.view.InputCarNames
import racingcar.view.InputRoundCount
import racingcar.view.OutputRaceProgress

class GameController {

    fun startGame() {
        val carNames = InputCarNames.invoke()
        val cars = Cars.from(carNames)
        val roundCount = InputRoundCount.invoke()

        repeat(roundCount) { // repoeat number of rounds
            startTurn(cars)
        }

    }

    private fun startTurn(cars: Cars) {
        cars.raceOnce() // Race the car once
        OutputRaceProgress.showRace(cars) // Print the results of one round
    }
}