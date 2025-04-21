package racingcar.controller

import racingcar.domain.Cars
import racingcar.domain.Round
import racingcar.view.InputView

class GameController {
    fun start() {
        val cars = Cars.from(InputView.readCarNames())
        val round = Round.from(InputView.readRound())

        race(cars, round)
    }

    fun race(cars: Cars, round: Round) {
        repeat(round.round) {
            cars.moveAll()
        }
    }
}