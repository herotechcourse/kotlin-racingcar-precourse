package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program

    val cars = getCarNames()
    val rounds = getNumberOfRounds()

    val carPositions = mutableMapOf<String, Int>()
    cars.forEach {
        carPositions[it] = 0
    }

    repeat(rounds) { round ->
        println("Race Results")
        for (car in cars) {
            carPositions[car] = generateRandomNumbers(carPositions[car]!!)
            println("$car : ${"-".repeat(carPositions[car]!!)}")
        }
    }

    val maxPosition = carPositions.values.maxOrNull() ?: 0
    val winners = carPositions.filterValues { it == maxPosition }.keys
    println("Winner${if (winners.size > 1) "s" else ""} : ${winners.joinToString(", ")}")
}

fun getCarNames(): List<String> {

    do {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()?.trim() ?: continue
        val carNames = carNamesInput.split(",").map { it.trim() }

        if(carNames.all { it.isNotEmpty() && it.length <= 5 }) {
            return carNames
        } else {
            throw IllegalArgumentException("Name must not be empty and only 5 characters. Try again!")
        }

    } while (true)
}

fun getNumberOfRounds(): Int {
    while (true) {
        println("How many rounds will be played?")
        val numberOfRoundsInput = Console.readLine()
        val numberOfRounds = numberOfRoundsInput?.toIntOrNull()

        if(numberOfRounds != null && numberOfRounds > 0) {
            return numberOfRounds
        } else {
            throw IllegalArgumentException("Invalid input: enter a positive number")
        }
    }
}

fun generateRandomNumbers(currentPosition: Int): Int {
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    return if (randomNumber >= 4) currentPosition + 1 else currentPosition
}
