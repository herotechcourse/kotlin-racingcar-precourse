package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var position: Int = 0)

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
    println("Winners: ${winners.joinToString(",")}")
}
// Read and validate car names
fun getCarNames(): List<Car> {
    println("Enter names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    if (names.isEmpty()) throw IllegalArgumentException("No car names provided")
    return names.map { name ->
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("Invalid car name: '$name'")
        }
        Car(name)
    }
}

fun getNumberOfRounds(): Int {
    println("Enter number of rounds:")
    val input = Console.readLine()
    val rounds = input.toIntOrNull()
        ?: throw IllegalArgumentException("Rounds must be a number.")
    if (rounds <= 0) throw IllegalArgumentException("Rounds must be greater than 0.")
    return rounds
}
fun playRound(cars: List<Car>) {
    for (car in cars) {
        moveIfPossible(car)
    }
}
// Decide whether a car moves forward
fun moveIfPossible(car: Car) {
    val number = Randoms.pickNumberInRange(0, 9)
    if (number >= 4) {
        car.position += 1
    }
}
// Print car's progress
fun printRaceStatus(cars: List<Car>) {
    for (car in cars) {
        println("${car.name} : ${"-".repeat(car.position)}")
    }
}
fun getWinners(cars: List<Car>) : List<String> {
    val maxPosition = cars.maxOf { it.position }
    return cars.filter { it.position == maxPosition }.map { it.name }
}