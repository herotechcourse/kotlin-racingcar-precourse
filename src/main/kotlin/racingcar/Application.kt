package racingcar

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.view.InputView

fun main() {
    val carNames = InputView.readNames()
    val rounds = InputView.readRoundNumber()
    val cars: List<Car> = carNames.map { Car(it) }
    val game = RacingGame(cars, rounds)

    game.play()
}
