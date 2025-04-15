package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("Car names should be 5 characters or less.")
    }

    println("Number of rounds ?")
    val roundCount = Console.readLine().toInt()

    val cars = carNames.map { Car(it) }

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

    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
    println("Winners : $winners")
}

class Car(val name: String, var position: Int = 0) {
    fun move() {
        position++
    }
}
