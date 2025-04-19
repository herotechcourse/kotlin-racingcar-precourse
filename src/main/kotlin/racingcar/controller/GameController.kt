package racingcar.controller

import racingcar.view.InputView
import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.OutputView

/**
 * Controls the flow of the racing car game.
 * Handles domains initialization, simulation, and winner announcement.
 */
class GameController() {
    private var race: Race
    private var raceEnds = false

    /**
     * Initializes the race class with cars instances and number of rounds provided by the user input
     */
    init {
        val carNames = InputView.getCarNames()
        val rounds = InputView.getRounds()
        val cars = carNames.map { Car(it) }
        this.race = Race(cars, rounds)
    }

    /**
     * Starts and simulates the race, then displays the race history to the user.
     */
    fun start() {
        this.race.simulate()
        OutputView.displayRace(this.race.raceHistory)
        this.raceEnds = true
    }

    /**
     * Announces the winners of the race.
     * throw IllegalStateException if the race hasn't been completed
     */
    fun announceWinners() {
        check(this.raceEnds) { "Cannot announce winner: race has not started" }
        OutputView.announceWinners(race.getWinners())
    }
}