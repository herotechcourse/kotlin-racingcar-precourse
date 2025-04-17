package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program

    //1. get inputs of player names - readCarNames()
    val carNames = readCarNames()

    //2. get inputs of rounds
    val numberOfRounds = readNumberOfRounds()

    //3. function: make random result

    //4. print racing result (player names, random function)

    //5. calculate who wins

    //6. print winner
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