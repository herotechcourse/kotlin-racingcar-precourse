package racingcar
//package racing car

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
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine() ?: ""
        val carNames = carNamesInput.split(",").map { it.trim() }

        if (carNames.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("Car names must be between 1 and 5 characters long.")
        }

        val cars = carNames.map { Car(it) }

        println("How many rounds will be played?")
        val roundsInput = Console.readLine() ?: ""
        val numberOfRounds = roundsInput.toIntOrNull()

        if (numberOfRounds == null || numberOfRounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer.")
        }

        println("\nRace Results")
        for (round in 1..numberOfRounds) {
            for (car in cars) {
                car.move()
                println("${car.name} : ${car.getProgress()}")
            }
            println()
        }

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
    // TODO: Implement the program
    try {
        Application().run()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
