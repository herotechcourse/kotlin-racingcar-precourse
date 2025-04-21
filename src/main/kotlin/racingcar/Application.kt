package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    Application().main()
}

class Application {
    fun main() {
        // validating car names from user input
        val cars = getCarNames()
        val rounds = getNumberOfRounds()
        println("\nRace Results!\n")

        // Specified number of rounds
        repeat(rounds) {
            playRound(cars)
            printRaceStatus(cars)
            println()
        }
        // Print winners
        val winners = getWinners(cars)
        println("Winners : ${winners.joinToString(",")}")
    }

    // Read and validate car names
    private fun getCarNames(): List<Car> {
        println("Enter names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        if (names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Car names must be 5 characters.")
        }
        return names.map { Car(it) }
    }

    private fun getNumberOfRounds(): Int {
        println("Enter number of rounds:")
        val input = Console.readLine()
        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("Rounds must be a number.")
        if (rounds <= 0) {
            throw IllegalArgumentException("Rounds must be greater than 0.")
        }
        return rounds
    }

    private fun playRound(cars: List<Car>) {
        for (car in cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move()
            }
        }
    }

    private fun printRaceStatus(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    private fun getWinners(cars: List<Car>): List<String> {
        val max = cars.maxOf { it.position }
        return cars.filter { it.position == max }.map { it.name }
    }
}
// Car class
class Car(val name: String, var position: Int = 0) {
    fun move() {
        position += 1
    }
}
