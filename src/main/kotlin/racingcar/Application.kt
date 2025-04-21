package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = InputHandler.parseCarNames(carNamesInput)

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val totalRounds = InputHandler.parseRoundCount(roundsInput)

    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars, totalRounds)

    println("\nRace Results")
    game.start()
    game.printWinners()
}

// validating and parsing car names
fun parseCarNames(input: String): List<String> {
    val names = input.split(",").map { it.trim() }
    if (names.isEmpty() || names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Car names must be non-empty and up to 5 characters.")
    }
    return names
}

// parsing and validating round count
fun parseRoundCount(input: String): Int {
    val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Round count must be a number.")
    if (rounds <= 0) throw IllegalArgumentException("Round count must be greater than zero.")
    return rounds
}