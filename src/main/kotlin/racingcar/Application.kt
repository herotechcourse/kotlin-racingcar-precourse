package racingcar

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.service.RaceService
import racingcar.service.movement.RandomMovementStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val names = InputView.readCarNames()
    val rounds = InputView.readRoundCount()

    val cars = names.map { Car(it) }
    val race = Race(cars)

    val raceService = RaceService(RandomMovementStrategy())
    val (history, finalRace) = raceService.play(race, rounds)

    OutputView.printProgress(history)
    OutputView.printWinners(finalRace.winners())
}
