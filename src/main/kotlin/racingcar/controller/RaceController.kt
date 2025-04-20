package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    fun play() {
            val carNames = InputView.getCarNames()
            val rounds = InputView.getRoundCounts()

            val cars = carNames.map { Car(it) }
            val race = Race(cars, rounds)

            OutputView.printRaceIntro()
            runRace(race)
            announceWinners(race)
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