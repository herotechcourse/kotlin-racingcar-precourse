package racingcar

import racingcar.domain.Car
import racingcar.input.InputView
import racingcar.output.OutputView
import racingcar.service.CarService

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val carNames = inputView.readCarNames()
    val round = inputView.readRounds()

    val cars = carNames.map { Car(it) }

    val service = CarService(cars, round, outputView)
    val result = service.startRace()


}