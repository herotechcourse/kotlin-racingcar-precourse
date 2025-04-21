package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }

    validateCarNames(carNames)

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()

    val numberOfRounds = try {
        roundsInput.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Number of rounds must be a valid integer.")
    }

    if (numberOfRounds <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0.")
    }

    val cars = carNames.map { Car(it) }

    println("\nRace Results")

    repeat(numberOfRounds) {
        for (car in cars) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.moveForward()
            }
            println("${car.name} : ${car.getProgress()}")
        }
        println()
    }
    val maxPosition = cars.maxOf { it.getPosition() }
    val winners = cars.filter { it.getPosition() == maxPosition }
        .joinToString(", ") { it.name }

    println("Winners : $winners")
}

fun validateCarNames(carNames: List<String>) {
    for (name in carNames) {
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("Each car name must be 1 to 5 characters long.")
        }
    }
}

class Car(val name: String) {
    private var position: Int = 0

    fun moveForward() {
        position++
    }

    fun getProgress(): String {
        return "-".repeat(position)
    }

    fun getPosition(): Int {
        return position
    }
}
