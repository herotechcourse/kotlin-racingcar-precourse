package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val carNames = readCarNames()
        val roundCount = readRoundCount()
        val cars = carNames.map { Car(it) }

        println("\nRace Results")
        repeat(roundCount) {
            raceOnce(cars)
            printStatus(cars)
        }

        for (car in cars) {
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    private fun readCarNamesInput(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }

    private fun readCarNames(): List<String> {
        val input = readCarNamesInput().trim()
        val names = input.split(",").map { it.trim() }

        if (names.isEmpty() || names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be 1–5 characters.")
        }

        return names
    }

    private fun readRoundCountInput(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }

    private fun readRoundCount(): Int {
        val input = readRoundCountInput().trim()
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
    }

    private fun raceOnce(cars: List<Car>) {
        for (car in cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move()
            }
        }
    }

    private fun printStatus(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
}