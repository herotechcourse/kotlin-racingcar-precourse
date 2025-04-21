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
//        try {
            val cars = createValidatedCars()
            val rounds = readValidatedRounds()

            runRaceAndShowResults(cars, rounds)

//        } catch (e: IllegalArgumentException) {
//            println(e.message)
//        }
    }

    // This method is called by the test
    fun runException(carNames: String, rounds: String) {
        // Don't catch exceptions in test mode - let them propagate
        val carsList = createCarsFromInput(carNames)
        val roundsCount = parseRounds(rounds)
        runRaceAndShowResults(carsList, roundsCount)
    }

    private fun createValidatedCars(): List<Car> {
        try {
            val carNamesInput = inputView.readCarNames()
            validator.validateCarNames(carNamesInput)
            return carNamesInput.split(",").map { Car(it.trim()) }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            throw e
        }
//        val carNamesInput = inputView.readCarNames()
//        validator.validateCarNames(carNamesInput)
//        return carNamesInput.split(",").map { Car(it.trim()) }
    }

    private fun readValidatedRounds(): Int {
        try {
            val roundsInput = inputView.readRounds()
            validator.validateRoundCount(roundsInput)
            return roundsInput.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            throw e
        }
//        val roundsInput = inputView.readRounds()
//        validator.validateRoundCount(roundsInput)
//        return roundsInput.toInt()
    }

    // Helper methods for test
    private fun createCarsFromInput(carNames: String): List<Car> {
        validator.validateCarNames(carNames)
        return carNames.split(",").map { Car(it.trim()) }
    }

    private fun parseRounds(rounds: String): Int {
        validator.validateRoundCount(rounds)
        return rounds.toInt()
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