package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val cars = promptForCars()
    val rounds = promptForRounds()
    val raceResults = simulateRace(cars, rounds)
    val winners = determineWinners(raceResults)
    printWinners(winners)
}

data class Car(val name: String, val position: Int = 0)

fun promptForCars(): List<Car> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    return parseCarNames(input)
}

fun parseCarNames(input: String): List<Car> {
    val maxNameLength = 5
    val names = input.split(",").map { it.trim() }

    if (names.isEmpty()) {
        throw IllegalArgumentException("At least one car name must be provided.")
    }

    names.forEach { name ->
        if (name.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty.")
        }

        if (name.length > maxNameLength) {
            throw IllegalArgumentException("Car names cannot exceed $maxNameLength characters: $name")
        }
    }

    return names.map { Car(it) }
}

fun promptForRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()

    return try {
        val rounds = input.toInt()
        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be positive.")
        }
        rounds
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Number of rounds must be a valid integer.")
    }
}

fun simulateRace(cars: List<Car>, rounds: Int): List<List<Car>> {
    println("\nRace Results")

    return (1..rounds).fold(listOf(cars)) { raceHistory, _ ->
        val updatedCars = raceHistory.last().map { car ->
            if (shouldMoveForward()) {
                moveForward(car)
            } else {
                car
            }
        }

        printRoundResult(updatedCars)
        raceHistory + listOf(updatedCars)
    }
}

fun shouldMoveForward(): Boolean {
    val minimumMoveValue = 4
    return Randoms.pickNumberInRange(0, 9) >= minimumMoveValue
}

fun moveForward(car: Car): Car = car.copy(position = car.position + 1)

fun printRoundResult(cars: List<Car>) {
    cars.forEach { car ->
        println("${car.name} : ${"-".repeat(car.position)}")
    }
    println()
}

fun determineWinners(raceResults: List<List<Car>>): List<Car> {
    val finalState = raceResults.last()
    val maxPosition = finalState.maxOf { it.position }

    return finalState.filter { it.position == maxPosition }
}

fun printWinners(winners: List<Car>) {
    val winnerNames = winners.joinToString(", ") { it.name }
    println("Winners : $winnerNames")
}
