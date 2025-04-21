package racingcar.controller

import racingcar.decider.WinnerDecider
import racingcar.domain.Car
import racingcar.formatter.OutputFormatter
import racingcar.generator.NumberGenerator
import racingcar.validator.InputValidator


class RaceGame(
    private val validator: InputValidator,
    private val numberGenerator: NumberGenerator,
    private val winnerDecider: WinnerDecider,
    private val outputFormatter: OutputFormatter
) {
    fun start() {
        val scanner = java.util.Scanner(System.`in`)

        print("Enter the names of the cars (comma-separated): ")
        val carNames = validator.validateCarNames(scanner.nextLine())

        print("How many rounds will be played? ")
        val rounds = validator.validateRounds(scanner.nextLine())

        println("\nRace Results")

        // create domain objects
        val cars = carNames.map { Car(it) }

        // run rounds
        repeat(rounds) { round ->
            cars.forEach { car -> car.move(numberGenerator.generate()) }
            println(outputFormatter.formatRoundStatus(cars))
            println()
        }

        // decide and print winners
        val winners = winnerDecider.decide(cars)
        println(outputFormatter.formatWinners(winners))
    }
}