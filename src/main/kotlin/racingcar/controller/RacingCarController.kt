package racingcar.controller

import racingcar.view.InputView
import racingcar.domain.RacingCar
import racingcar.view.OutputView

class RacingCarController {
    var names = InputView.inputCarNames()
    val rounds = InputView.inputRounds()
    val cars = names.map { RacingCar(it) }

    fun start() {
        repeat(rounds) {
            cars.forEach {
                car -> car.run()
            }
            OutputView.printCarRound(cars)
        }
    }
}


