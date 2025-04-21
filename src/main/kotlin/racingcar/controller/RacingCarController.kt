package racingcar.controller

import racingcar.view.InputView
import racingcar.domain.RacingCar
import racingcar.view.OutputView
import racingcar.domain.Race

class RacingCarController {

    init {
        var names = InputView.inputCarNames()
        val rounds = InputView.inputRounds()
        val cars = names.map { RacingCar(it) }
        val races = Race(cars)

        repeat(rounds)
        {
            races.playAllGrounds()
            OutputView.printCarRound(races.getCars())
        }

        OutputView.printWinners(races.getWinners())
    }
}


