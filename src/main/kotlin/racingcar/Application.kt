package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carRacing = CarRacing()
    carRacing.start()
}

class CarRacing {
    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val FORWARD_THRESHOLD = 4
        private const val MIN_RANDOM = 0
        private const val MAX_RANDOM = 9
    }

    fun start() {
        try {
            // Get car names from user
            println("Enter the names of the cars (comma-separated):")
            val carNames = readCarNames()
            
            // Get number of rounds from user
            println("How many rounds will be played?")
            val rounds = readRounds()
            
            // Create cars
            val cars = createCars(carNames)
            
            // Run the race
            println("\nRace Results")
            runRace(cars, rounds)
            
            // Display winners
            displayWinners(cars)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    
    private fun readCarNames(): List<String> {
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        
        validateCarNames(carNames)
        return carNames
    }
    
    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
        
        carNames.forEach { name ->
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car name cannot be empty")
            }
            if (name.length > MAX_NAME_LENGTH) {
                throw IllegalArgumentException("Car name cannot exceed 5 characters: $name")
            }
        }
    }
    
    private fun readRounds(): Int {
        val input = Console.readLine()
        try {
            val rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be positive")
            }
            return rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid number of rounds")
        }
    }
    
    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }
    
    private fun runRace(cars: List<Car>, rounds: Int) {
        repeat(rounds) {
            moveAllCars(cars)
            displayRaceStatus(cars)
        }
    }
    
    private fun moveAllCars(cars: List<Car>) {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM)
            if (randomNumber >= FORWARD_THRESHOLD) {
                car.moveForward()
            }
        }
    }
    
    private fun displayRaceStatus(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }
    
    private fun displayWinners(cars: List<Car>) {
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        
        println("Winners : ${winners.joinToString(", ")}")
    }
}

class Car(val name: String) {
    var position: Int = 0
        private set
    
    fun moveForward() {
        position++
    }
}