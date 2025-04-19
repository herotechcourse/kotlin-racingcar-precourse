import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Car racing game!")
    promptForCars()
    promptForRounds()
}

data class Car(val name: String, val position: Int = 0)

fun promptForCars(): List<Car> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    return parseCarNames(input)
}

fun parseCarNames(input: String): List<Car> {
    val maxNameLength = 5
    val names = input.split(",").map { it.trim() }

    if (names.isEmpty()) {
        throw IllegalArgumentException("At least one car name must be provided.")
    }

    names.forEach { name ->
        if (name.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty.")
        }

        if (name.length > maxNameLength) {
            throw IllegalArgumentException("Car names cannot exceed $maxNameLength characters: $name")
        }
    }

    return names.map { Car(it) }
}

fun promptForRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()

    return try {
        val rounds = input.toInt()
        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be positive.")
        }
        rounds
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Number of rounds must be a valid integer.")
    }
}