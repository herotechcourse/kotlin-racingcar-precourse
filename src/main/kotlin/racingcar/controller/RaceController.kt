package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    fun play() {
        try {
            val carNames = InputView.getCarNames()
            val rounds = InputView.getRoundCounts()

            val cars = carNames.map { Car(it) }
            val race = Race(cars, rounds)

            OutputView.printRaceIntro()
            runRace(race)
            announceWinners(race)
        } catch (e: IllegalArgumentException) {
            OutputView.printError(e.message ?: "An error is occurred")
        }
    }

    private fun runRace(race: Race) {
        while (!race.isFinished()) {
            race.playRound()
            OutputView.printRoundResults(race.cars)
        }
    }

    private fun announceWinners(race: Race) {
        val winners = race.findWinners()
        OutputView.printWinners(winners)
    }
}