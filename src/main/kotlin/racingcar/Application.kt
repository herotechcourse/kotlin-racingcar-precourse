package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// Car class
class Car(val name: String) {
    var position: Int = 0

    // Move forward if random number is 4 or greater
    fun tryMove() {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            position++
        }
    }

    // Show progress
    fun showProgress() {
        println("$name : ${"-".repeat(position)}")
    }
}

fun main() {
    // TODO: Implement the program
    // 1. Get names
    println("Enter the names of the cars (comma-separated):")
    val names = Console.readLine()  ?: ""
    val nameList = names.split(",").map { it.trim() }

    for (name in nameList) {
        if (name.length > 5 || name.isBlank()) {
            throw IllegalArgumentException("Each name must be between 1 and 5 characters.: '$name'")
        }
    }

    // 2. Get rounds
    println("How many rounds will be played?")
    val roundInput = Console.readLine() ?: throw IllegalArgumentException("No input provided.")
    val numberOfRounds = roundInput.toIntOrNull()

    if (numberOfRounds == null || numberOfRounds <= 0) {
        throw IllegalArgumentException("The number of rounds must be a positive integer.")
    }

    // 3. Create a list of Car objects
    val cars = nameList.map { Car(it) }

    // 4. Start the race
    println("\nRace Results")
    repeat(numberOfRounds) {
        cars.forEach { car ->
            car.tryMove()
            car.showProgress()
        }
        println()
    }

    // 5. Find the maximum position among all cars
    val maxPosition = cars.maxOf { it.position }

    // 6. Get all winners (cars with the same final position)
    val winners = cars.filter { it.position == maxPosition }.map { it.name }

    // 7. Print the winners
    println("Winners : ${winners.joinToString(", ")}")
}