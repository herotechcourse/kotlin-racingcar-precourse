package racingcar.controller

import racingcar.view.InputView
import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.OutputView

class GameController {
    private var race: Race? = null
    private var raceEnds = false

    fun init(): Unit {
        val carNames = InputView.getCarNames()
        val rounds = InputView.getRounds()

        val cars = carNames.map { Car(it) }
        race = Race(cars, rounds)
    }

    private fun currentRace() = checkNotNull(race) { "Race must be initialize before it can be used" }

    fun start() {
        val activeRace = currentRace()
        activeRace.simulate()
        OutputView.displayRace(activeRace.raceHistory)
        raceEnds = true
    }

    fun announceWinners() {
        check(raceEnds) { "Cannot announce winner: race has not started" }
        OutputView.announceWinners(currentRace().getWinners())
    }
}