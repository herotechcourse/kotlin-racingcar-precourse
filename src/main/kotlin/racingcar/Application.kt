package racingcar

import racingcar.domain.*
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val carNames = inputView.readCarNames()
    val cars = createCars(carNames)
    val numberOfRounds = inputView.readNumberOfRounds()
    val race = Race(Cars(cars), numberOfRounds)

    val raceResults = race.start()

    printResults(raceResults)
}

private fun createCars(carNames: List<String>) =
    carNames.map { CarName(it) }.map { Car(it, RandomPowerGenerator()) }.toList()

private fun printResults(raceResults: RaceResults) {
    val outputView = OutputView()
    outputView.printRaceResults(raceResults)
}
