package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val names = readCarNames()
    val rounds = readRounds()

    val cars = names.map { Car(it) }

    println("\nRace Results")
    repeat(rounds) {
        cars.forEach { it.tryMove() }
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
    }

    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.map { it.name }
    println("\nWinners : ${winners.joinToString(", ")}")
}

// Car class
class Car(val name: String) {
    var position: Int = 0
        private set

    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Car names must be 1 to 5 characters long."
        }
    }

    fun tryMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}

// Input functions
fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    if (names.isEmpty() || names.any { it.isBlank() || it.length > 5 }) {
        throw IllegalArgumentException("Invalid car names. Each must be 1–5 characters.")
    }
    return names
}

fun readRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    return input.toIntOrNull()?.takeIf { it > 0 }
        ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
}
