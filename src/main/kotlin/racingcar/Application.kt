package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var position: Int = 0

    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("Car name cannot be empty.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters.")
        }
    }

    fun move() {
        try {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                position++
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("Failed to generate random number.")
        }
    }

    fun getPosition(): Int = position
}

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine()
    val cars = createCars(carNames)
    
    println("How many rounds will be played?")
    val rounds = readRounds()

    println("\nRace Results")
    repeat(rounds) { round ->
        cars.forEach { car ->
            car.move()
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    // Find the maximum position
    var maxPosition = 0
    for (car in cars) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition()
        }
    }

    // Find all cars with the maximum position
    val winners = mutableListOf<String>()
    for (car in cars) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.name)
        }
    }

    // Display winners
    print("Winners : ")
    for (i in winners.indices) {
        print(winners[i])
        if (i < winners.size - 1) {
            print(", ")
        }
    }
    println()
}

private fun readRounds(): Int {
    val input = Console.readLine()
    validateRounds(input)
    return input.toInt()
}

private fun validateRounds(input: String) {
    if (input.isBlank()) {
        throw IllegalArgumentException("Round number cannot be empty.")
    }
    if (!input.all { it.isDigit() }) {
        throw IllegalArgumentException("Round number must be a positive integer.")
    }
    val rounds = input.toInt()
    if (rounds <= 0) {
        throw IllegalArgumentException("Round number must be greater than 0.")
    }
}

private fun createCars(carNames: String): List<Car> {
    val names = carNames.split(",").map { it.trim() }
    validateCarNames(names)
    return names.map { Car(it) }
}

private fun validateCarNames(names: List<String>) {
    if (names.isEmpty()) {
        throw IllegalArgumentException("Car names cannot be empty.")
    }
    if (names.any { it.isBlank() }) {
        throw IllegalArgumentException("Car name cannot be empty.")
    }
    if (names.any { it.length > 5 }) {
        throw IllegalArgumentException("Car name cannot exceed 5 characters.")
    }
    if (names.distinct().size != names.size) {
        throw IllegalArgumentException("Car names cannot be duplicated.")
    }
}

