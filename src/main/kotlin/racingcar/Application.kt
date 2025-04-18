package racingcar

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.ui.InputView
import racingcar.ui.OutputView

fun main() {
    Application().run()
}

class Application {
    fun run() {
        try {
            val inputView = InputView()
            val outputView = OutputView()

            // Get input from user
            val carNames = inputView.readCarNames()
            val roundCount = inputView.readRounds()

            // Create cars and validate
            val cars = carNames.split(",").map { Car(it.trim()) }
            val rounds = roundCount.toInt()

            // Create and run the race
            val race = Race(cars, rounds)

            // Execute each round and show progress
            for (round in 1..rounds) {
                // Move cars for this round
                race.executeRound()

                // Display results after this round
                outputView.printRaceResults(cars)
            }

            // Determine and show winners
            val winners = race.determineWinners()
            outputView.printWinners(winners)

        } catch (e: Exception) {
            println("Error occurred: ${e.message}")
        }
    }
}