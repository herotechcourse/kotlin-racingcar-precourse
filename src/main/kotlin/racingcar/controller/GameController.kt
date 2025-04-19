package racingcar.controller

import racingcar.view.InputView
import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.OutputView

class GameController() {
    private var race: Race
    private var raceEnds = false

    init {
        val carNames = InputView.getCarNames()
        val rounds = InputView.getRounds()
        val cars = carNames.map { Car(it) }
        this.race = Race(cars, rounds)
    }

    fun start() {
        this.race.simulate()
        OutputView.displayRace(this.race.raceHistory)
        this.raceEnds = true
    }

    fun announceWinners() {
        check(this.raceEnds) { "Cannot announce winner: race has not started" }
        OutputView.announceWinners(race.getWinners())
    }
}