package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(private val name: String) {
    private var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun getPosition(): Int = position
    fun getName(): String = name

    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }
}

fun main() {

    // 1. Get car names from user input (List<String>)
    val carNames = readCarNames()

    // 2. Get number of rounds to run
    val numberOfRounds = readNumberOfRounds()

    // 3. Create Car objects from names, run the race
    println("\nRace Results")
    val cars = carNames.map { Car(it) }
    playRace(cars, numberOfRounds) // cars move and print status per round

    // 4. Print the final winner(s)
    printWinners(cars)
}


fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()

    val carNames = input.split(",").map { it.trim() }


    if (carNames.isEmpty() || carNames.any { it.isEmpty() }) {
        throw IllegalArgumentException("It can't be empty.")
    }

    if (carNames.size < 2) {
        throw IllegalArgumentException("At least two cars are required.")
    }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("Only up to 5characters are allowed.")
    }

    return carNames
}

fun readNumberOfRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()

    val number = input.toIntOrNull()
        ?: throw IllegalArgumentException("Please enter a valid number.")

    if (number <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0.")
    }

    return number
}

fun playRace(cars: List<Car>, numberOfRounds: Int) {
    repeat(numberOfRounds) {
        cars.forEach { it.move() }
        cars.forEach { it.printStatus() }
        println()
    }
}





fun printWinners(cars: List<Car>) {
    val maxPosition = cars.maxOf { it.getPosition() }
    val winners = cars
        .filter { it.getPosition() == maxPosition }
        .joinToString(", ") { it.getName() }

    println("Winners : $winners")
}



