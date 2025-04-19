package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val userInput = Console.readLine()
    val carNames = validCarNames(userInput)

    println("Enter the number of rounds:")
    val roundsInput = Console.readLine()
    val numberOfRounds = validNumberOfRounds(roundsInput)

    val cars = carNames.map { Car(it) }

    repeat(numberOfRounds) { roundIndex ->
        println("Round ${roundIndex + 1}:")
        cars.forEach { car -> car.move() }
        cars.forEach { car -> println(car.getProgress()) }
        println()
    }

    println("You entered: $carNames")
    println("You entered: $roundsInput")

    printWinners(cars)
}


// Example Input: "BMW,KIA,Toyota"
// Example Output: [BMW, KIA, Toyota]
fun validCarNames(input: String): List<String> {
    val carNames = input.split(",").map { it.trim() }

    carNames.forEach {
        if (it.length > 5 || it.isEmpty()) {
            throw IllegalArgumentException("Car name must be 1 to 5 characters long.")
        }
    }

    return carNames
}


fun validNumberOfRounds(input: String): Int {
    val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Invalid number of rounds.")
    return rounds
}

class Car(private val name: String) {
    private var steps: Int = 0

    fun move() {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            steps++
        }
    }

    fun getProgress(): String {
        return "$name : ${"-".repeat(steps)}"
    }

    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return steps
    }
}

fun printWinners(cars: List<Car>) {
    val maxPosition = cars.maxOf { it.getPosition() }
    val winners = cars.filter { it.getPosition() == maxPosition }
        .map { it.getName() }

    println("Winners : ${winners.joinToString()}")
}

