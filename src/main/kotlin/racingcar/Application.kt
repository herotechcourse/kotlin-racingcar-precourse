package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.service.Race.getWinners
import racingcar.service.Race.startRace


fun main() {
    // Get user input for car names and race rounds
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine().split(",").map { it.trim() }
    val cars = carNames.map { Car(it) }

    println("How many rounds will be played:")
    val rounds = Console.readLine().toIntOrNull() ?: 0

    // Run the race
    startRace(cars, rounds)

    // Display Winners
    val winners = getWinners(cars)
    println("Winners : ${winners.joinToString(", ")}")
}


