import kotlin.random.Random

class CarRacingGame {
    private val cars = mutableListOf<Car>()
    private var rounds = 0

    fun startGame() {
        try {
            setupGame()
            playGame()
            printResults()
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}")
        }
    }

    private fun setupGame() {
        println("Names of the cars (comma-separated):")
        val carNamesInput = readLine()?.trim() ?: throw IllegalArgumentException("Input cannot be empty")

        val carNames = carNamesInput.split(",").map { it.trim() }
        validateCarNames(carNames)

        println("Number of rounds:")
        rounds = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number")
        if (rounds <= 0) throw IllegalArgumentException("Rounds must be positive")

        cars.addAll(carNames.map { Car(it) })
    }

    private fun validateCarNames(carNames: List<String>) {
        if (carNames.isEmpty()) throw IllegalArgumentException("At least one car is required")
        
        carNames.forEach { name ->
            if (name.isEmpty()) throw IllegalArgumentException("Car name cannot be empty")
            if (name.length > 5) throw IllegalArgumentException("Car name '$name' exceeds 5 characters")
        }
    }

    private fun playGame() {
        println("\nRace results by round:")
        repeat(rounds) {
            moveCars()
            printProgress()
        }
    }

    private fun moveCars() {
        cars.forEach { car ->
            if (shouldMove()) car.move()
        }
    }

    private fun shouldMove(): Boolean {
        return Random.nextInt(0, 10) >= 4
    }

    private fun printProgress() {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    private fun printResults() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        
        println("Winners : ${winners.joinToString(", ")}")
    }
}

data class Car(val name: String, var position: Int = 0) {
    fun move() {
        position++
    }
}

fun main() {
    val game = CarRacingGame()
    game.startGame()
}