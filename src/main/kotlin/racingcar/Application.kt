package racingcar

import racingcar.domain.Race
import racingcar.ui.InputView

fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val race = Race()

    val cars = inputView.getCars()
    val attempts = inputView.getAttempts()

    race.race(cars,attempts)
}
