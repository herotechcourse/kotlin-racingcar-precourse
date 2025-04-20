package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Race
import racingcar.util.InputParser
import racingcar.util.InputValidator
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGameController {

    fun run() {
        val carNames = readAndValidateCarNames()
        val rounds = readAndValidateRounds()

        println()
        println("Race Results")

        val cars = Cars(carNames.map { Car(it) })
        val race = Race(cars, rounds)

        val history = race.play()
        history.forEach { roundState ->
            ResultView.printRound(roundState)
        }

        val winners = race.winners()
        ResultView.printWinners(winners)
    }

    private fun readAndValidateCarNames(): List<String> {
        val raw = InputView.inputCarName()
        val names = InputParser.parseCarName(raw)

        InputValidator.validateCarName(names)

        return names
    }

    private fun readAndValidateRounds(): Int {
        val raw = InputView.inputPlayRound()
        val rounds = InputValidator.validateRounds(raw)

        return rounds
    }
}