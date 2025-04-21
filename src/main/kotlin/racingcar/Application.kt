package racingcar

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.domain.Validator
import racingcar.ui.InputView
import racingcar.ui.OutputView

fun main() {
    Application().run()
}

class Application {
    private val validator = Validator()
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val cars = createValidatedCars()
        val rounds = readValidatedRounds()
        runRaceAndShowResults(cars, rounds)
    }

    // This method is called by the test
    fun runException(carNames: String, rounds: String) {
        validator.validateCarNames(carNames)
        validator.validateRoundCount(rounds)
        val carsList = carNames.split(",").map { Car(it.trim()) }
        val roundsCount = rounds.toInt()
        runRaceAndShowResults(carsList, roundsCount)
    }

    private fun createValidatedCars(): List<Car> {
        val carNamesInput = inputView.readCarNames()
        validator.validateCarNames(carNamesInput)
        return carNamesInput.split(",").map { Car(it.trim()) }
    }

    private fun readValidatedRounds(): Int {
        val roundsInput = inputView.readRounds()
        validator.validateRoundCount(roundsInput)
        return roundsInput.toInt()
    }

    private fun runRaceAndShowResults(cars: List<Car>, rounds: Int) {
        val race = Race(cars, rounds)

        println("\nRace Results")
        for (round in 1..rounds) {
            race.executeRound()
            outputView.printRaceResults(cars)
        }

        val winners = race.determineWinners()
        outputView.printWinners(winners)
    }
}