package racingcar
import camp.nextstep.edu.missionutils.Console 
import camp.nextstep.edu.missionutils.Randoms
fun main() {
    val carNames = readCarNames()
    val roundCount = readRoundCount()

    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars, roundCount)

    println("\nRace Results")
    game.play()

    val winners = game.findWinners()
    println("\nWinners : ${winners.joinToString(", ")}")
}

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    if (names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be non-empty and at most 5 characters long.")
    }

    return names
}

fun readRoundCount(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()

    return input.toIntOrNull()?.takeIf { it > 0 }
        ?: throw IllegalArgumentException("Round count must be a positive integer.")
}

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun displayProgress(): String = "$name : ${"-".repeat(position)}"
}

class RacingGame(private val cars: List<Car>, private val rounds: Int) {
    fun play() {
        repeat(rounds) {
            cars.forEach { it.move() }
            cars.forEach { println(it.displayProgress()) }
            println()
        }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}

