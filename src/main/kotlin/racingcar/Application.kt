package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    //1. get inputs of player names
    val carNames = readCarNames()

    //2. get inputs of rounds
    val numberOfRounds = readNumberOfRounds()

    //3. playRace(carNames, numbersOfRounds) function: make random result
    // 3-1. moveCars(carNames, carPositions)
    // 3-2. printRaceStatus(carPositions)
    println("\nRace Results")
    val carPositions = playRace(carNames, numberOfRounds)

    //4. print winner
    printWinners(carPositions)

}

fun readCarNames(): List<String>? {
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

fun playRace(carNames: List<String>?, numberOfRounds: Int): Map<String, Int> {
    // where cars at, Map
    val carPositions = mutableMapOf<String, Int>()
    carNames?.forEach { carPositions[it] = 0 }

    repeat(numberOfRounds) {
        carNames?.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                carPositions[car] = carPositions[car]!! + 1
            }
        }

        printRaceStatus(carPositions)
    }

    return carPositions
}




fun printWinners(carPositions: Map<String, Int>) {
    val maxPosition = carPositions.values.maxOrNull()
        ?: throw IllegalArgumentException("No cars to evaluate.")

    val winners = carPositions.filter { it.value == maxPosition }
        .keys
        .joinToString(", ")

    println("Winners : $winners")
}

fun moveCars(carNames: List<String>, carPositions: MutableMap<String, Int>) {
    for (car in carNames) {
        carPositions[car] = carPositions[car]!! + 1
    }
}

fun printRaceStatus(carPositions: Map<String, Int>) {
    for ((car, position) in carPositions) {
        println("$car : ${"-".repeat(position)}")
    }
    println()
}