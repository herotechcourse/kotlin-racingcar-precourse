package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


class Application {
    fun main() {
        println("Enter the names of the cars (comma-separated):")
        val carNames = parseCarNamesInput(Console.readLine())
        val cars = carNames.map { Car(it) }

        println("How many rounds will be played?")
        val rounds = validateRoundsInput(Console.readLine())

        val race = Race(cars, rounds)
        race.runTheRace()

        val winners = listOf(cars.first())
        printRaceResults(cars)
        printRaceWinners(winners)
    }

    private fun parseCarNamesInput(input: String): List<String> {
        if (!input.contains(",")) {
            throw IllegalArgumentException("Car names should be comma-separated.")
        }
        val carNames = input.split(",").map { it.trim() }
        return carNames
    }

    private fun validateRoundsInput(input: String): Int {
        val rounds: Int
        try {
            rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be greater than 0.")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input. Please enter a valid integer for the number of rounds.")
        }
        return rounds;
    }

    private fun printRaceResults(results: List<Car>) {
        println("Race Results")
        results.forEach { println("${it.name} : ${"-".repeat(it.roundPoints)}") }
    }

    private fun printRaceWinners(winners: List<Car>) {
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}

fun main() {
    val game = Application()
    game.main()
}
