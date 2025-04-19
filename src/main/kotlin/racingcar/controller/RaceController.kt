package racingcar.controller

import racingcar.model.Car
import racingcar.model.RaceGame
import racingcar.parser.CarNameParser
import racingcar.parser.RoundsParser
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val carNameParser: CarNameParser,
    private val roundsParser: RoundsParser
) {
    fun start() {
        val carNamesInput = inputView.readCarNames()
        val carNames = carNameParser.parse(carNamesInput)

        val roundsInput = inputView.readRounds()
        val rounds = roundsParser.parse(roundsInput)

        val cars = carNames.map { carName -> Car(carName) }

        val raceGame = RaceGame(cars, rounds)

        runRace(raceGame)
    }

    private fun runRace(raceGame: RaceGame) {
        val listOfCars = raceGame.getListOfCars()
        println("Race Results")

        while (!raceGame.isRaceEnd()) {
            raceGame.startRound()
            outputView.showRoundResult(listOfCars)
        }

        val winningCars = raceGame.getWinners()
        outputView.showWinners(winningCars)

    }
}