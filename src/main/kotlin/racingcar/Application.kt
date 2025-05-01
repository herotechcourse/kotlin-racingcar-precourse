package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames = getCarNames()

    val roundCount = getRounds()
    val cars = carNames.map { Car(it) }

    runTheRace(roundCount, cars)

    announceTheWinners(cars)
}

private fun getRounds(): Int {
    println("Number of rounds ?")
    val input = Console.readLine()

    return try {
        val rounds = input.toInt()
        if (rounds <= 0) {
            throw IllegalArgumentException("Round cannot 0 or lower")
        }
        rounds
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Round must be a valid number")
    }
}

private fun announceTheWinners(cars: List<Car>) {
    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
    println("Winners : $winners")
}

private fun runTheRace(roundCount: Int, cars: List<Car>) {
    println("\nRace results by round:")
    repeat(roundCount) {
        cars.forEach { car ->
            val number = Randoms.pickNumberInRange(0, 9)
            if (number >= 4) {
                car.move()
            }
        }
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        println()
    }
}

private fun getCarNames(): List<String> {
    println("Names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }

    if (carNames.any { it.isEmpty() }) {
        throw IllegalArgumentException("Car names cannot be empty.")
    }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("Car names should be 5 characters or less.")
    }
    return carNames
}

class Car(val name: String, var position: Int = 0) {
    fun move() {
        position++
    }
}
