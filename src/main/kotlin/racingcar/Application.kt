package racingcar

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val names: List<String> = InputView.getCarNames()
    val rounds: Int = InputView.getRounds()

    val cars = names.map { Car(it) }.toList()
    val race = Race(cars, rounds)

    val roundResults = race.start()

    OutputView.printResultIntro()
    roundResults.forEach { roundSnapshot ->
        OutputView.printResults(roundSnapshot)
    }

    val winners = race.getWinners()
    OutputView.printWinners(winners)
}
