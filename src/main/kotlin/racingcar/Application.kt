package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun getProgress(): String {
        return "-".repeat(position)
    }
}

class Application {
    fun run() {
        val cars = getCars()
        val numberOfRounds = getNumberOfRounds()

        println("\nRace Results")
        simulateRace(cars, numberOfRounds)
        displayWinners(cars)
    }

    private fun getCars(): List<Car> {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine() ?: ""
        val carNames = carNamesInput.split(",").map { it.trim() }

        require(carNames.all { it.isNotEmpty() && it.length <= 5 }) { "Car names must be between 1 and 5 characters long." }
        return carNames.map { Car(it) }
    }

    private fun getNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val roundsInput = Console.readLine() ?: ""
        val numberOfRounds = roundsInput.toIntOrNull()

        require(numberOfRounds != null && numberOfRounds > 0) { "Number of rounds must be a positive integer." }
        return numberOfRounds
    }

    private fun simulateRace(cars: List<Car>, numberOfRounds: Int) {
        for (round in 1..numberOfRounds) {
            for (car in cars) {
                car.move()
                println("${car.name} : ${car.getProgress()}")
            }
            println()
        }
    }

    private fun displayWinners(cars: List<Car>) {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        val winnersMessage = if (winners.size == 1) {
            "Winners : ${winners.first()}"
        } else {
            "Winners : ${winners.joinToString(", ")}"
        }
        println(winnersMessage)
    }
}

fun main() {
    try {
        Application().run()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
