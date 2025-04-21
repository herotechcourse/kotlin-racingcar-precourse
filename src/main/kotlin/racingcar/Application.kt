package racing

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val game = RacingGame()
            game.start()
        }
    }
}

class RacingGame {
    fun start() {
        try {
            val carNames = inputCarNames()
            val rounds = inputRounds()

            val cars = createCars(carNames)

            println("\nRace Results")
            race(cars, rounds)

            val winners = determineWinners(cars)
            displayWinners(winners)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    // Method stubs to be implemented
    private fun inputCarNames(): List<String> { return emptyList() }
    private fun validateCarNames(carNames: List<String>) {}
    private fun inputRounds(): Int { return 0 }
    private fun createCars(carNames: List<String>): List<Car> { return emptyList() }
    private fun race(cars: List<Car>, rounds: Int) {}
    private fun displayRaceStatus(cars: List<Car>) {}
    private fun determineWinners(cars: List<Car>): List<Car> { return emptyList() }
    private fun displayWinners(winners: List<Car>) {}
}

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        position++
    }
}
private fun inputCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }

    validateCarNames(carNames)

    return carNames
}

private fun validateCarNames(carNames: List<String>) {
    if (carNames.isEmpty()) {
        throw IllegalArgumentException("Car names cannot be empty.")
    }

    for (name in carNames) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("Car name cannot be empty.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters: $name")
        }
    }
}

private fun inputRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()

    return try {
        val rounds = input.toInt()
        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be positive.")
        }
        rounds
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Invalid number format for rounds.")
    }
}

private fun createCars(carNames: List<String>): List<Car> {
    return carNames.map { Car(it) }
}

private fun race(cars: List<Car>, rounds: Int) {
    repeat(rounds) {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.move()
            }
        }

        displayRaceStatus(cars)
        println()
    }
}

private fun displayRaceStatus(cars: List<Car>) {
    cars.forEach { car ->
        println("${car.name} : ${"-".repeat(car.position)}")
    }
}

private fun determineWinners(cars: List<Car>): List<Car> {
    val maxPosition = cars.maxOfOrNull { it.position } ?: 0
    return cars.filter { it.position == maxPosition }
}

private fun displayWinners(winners: List<Car>) {
    val winnerNames = winners.joinToString(", ") { it.name }
    println("Winners : $winnerNames")
}