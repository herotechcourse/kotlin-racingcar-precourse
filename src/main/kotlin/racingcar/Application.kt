package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine() ?: ""

    val carNames = input.split(",").map { it.trim() }
    carNames.forEach {
        if (it.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters: $it")
        }
    }

    val cars = carNames.map { Car(it) }
    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    var rounds = 0

    if (roundsInput != null && roundsInput.toIntOrNull() != null) {
        rounds = roundsInput.toInt()
    } else {
        throw IllegalArgumentException("Invalid input for rounds.")
    }

    println("Race Results")
    repeat(rounds) { round ->
        println("Round ${round + 1}:")
        cars.forEach { car ->
            car.move()
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.map { it.name }
    println("Winners : ${winners.joinToString(", ")}")
}

data class Car(val name: String, var position: Int = 0) {
    fun move() {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        if (randomValue >= 4) {
            position++
        }
    }
}
