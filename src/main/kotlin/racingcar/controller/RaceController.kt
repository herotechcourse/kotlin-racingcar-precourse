package racingcar.controller

import racingcar.constants.MessageConstants
import racingcar.model.Car
import racingcar.model.RacingCars
import racingcar.util.RandomUtil
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {

    fun run() {
        val carNames = InputView.readCarNames();
        val roundCount = InputView.readRoundCount();

        val cars = carNames.map { Car(it) }
        val racingCars = RacingCars(cars)

        println(MessageConstants.MESSAGE_RACE_RESULT)
        repeat(roundCount) {
            racingCars.raceOneRound { RandomUtil.shouldMove() }
            OutputView.printRaceStatus(racingCars.getAllCars())
        }

        val winners = racingCars.findWinners().map { it.name }
        OutputView.printWinners(winners)
    }
}