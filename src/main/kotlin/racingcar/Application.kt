package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0)

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val carNames = Application().inputCarNames()
            val rounds = Application().inputRounds()
            val cars = carNames.map { Car(it) }

            Application().runRace(cars, rounds)
        }
    }

    private fun inputCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated): ")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        validateCarNames(carNames)
        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
        for (name in carNames) {
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car names cannot be empty")
            }
            if (name.length > 5) {
                throw IllegalArgumentException("Car name cannot exceed 5 characters")
            }
        }
    }

    private fun inputRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()

        return try {
            val rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Round cannot 0 or lower")
            }
            rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Round must be a valid number")
        }
    }

    private fun moveCar(car: Car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.position++
        }
    }

    private fun runRace(cars: List<Car>, rounds: Int) {
        println("\nRace Results")
        for (round in 1..rounds) {
            for (car in cars) {
                moveCar(car)
            }
            println("Round $round:")
            for (car in cars) {
                println("${car.name} : ${"-".repeat(car.position)}")
            }
            println()
        }
    }
}