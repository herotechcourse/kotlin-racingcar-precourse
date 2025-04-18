package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carRacing = CarRacing()
    carRacing.start()
}

fun main(args: Array<String>) {
    val carRacing = CarRacing()
    
    if (args.isNotEmpty()) {
        // Split command-line arguments and extract car names and rounds
        val carNames = args[0].split(",")
        val rounds = args.getOrNull(1)?.trim() ?: ""
        
        if (rounds.isEmpty()) {
            throw IllegalArgumentException("Missing or invalid number of rounds")
        }
        
        try {
            val roundsValue = rounds.toInt()
            carRacing.start(carNames, roundsValue)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Missing or invalid number of rounds")
        }
    } else {
        // If no arguments are passed, ask for interactive input
        carRacing.start()
    }
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
            println("Enter the names of the cars (comma-separated):")
            val carNames = readCarNames()
            
            println("How many rounds will be played?")
            val rounds = readRounds()
            
            start(carNames, rounds)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            throw e // Re-throw to ensure test failures
        }
    }
    
    fun start(carNames: List<String>, rounds: Int) {
        try {
            validateCarNames(carNames)
            
            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be positive")
            }
            
            val cars = createCars(carNames)
            
            println("\nRace Results")
            runRace(cars, rounds)
            
            displayWinners(cars)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            throw e  // Re-throw to ensure test failures
        }
    }
    
    private fun readCarNames(): List<String> {
        val input = Console.readLine().trim()
        
        if (input.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
        
        return input.split(",").map { it.trim() }
    }
    
    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
        
        for (name in carNames) {
            if (name.isEmpty()) {
                throw IllegalArgumentException("Car name cannot be empty")
            }
            if (name.length > MAX_NAME_LENGTH) {
                throw IllegalArgumentException("Car name cannot exceed 5 characters")
            }
        }
    }
    
    private fun readRounds(): Int {
        val input = Console.readLine().trim()
        
        if (input.isEmpty()) {
            throw IllegalArgumentException("Missing or invalid number of rounds")
        }
        
        try {
            val rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be positive")
            }
            return rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Missing or invalid number of rounds")
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
        for (car in cars) {
            val randomNumber = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM)
            if (randomNumber >= FORWARD_THRESHOLD) {
                car.moveForward()
            }
        }
    }
    
    private fun displayRaceStatus(cars: List<Car>) {
        for (car in cars) {
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