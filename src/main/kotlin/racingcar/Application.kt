package racingcar
import camp.nextstep.edu.missionutils.Console

fun readAndValidateNames(): List<String> {
    // Interactive form for user's car name input:
    println("Welcome to Racing Cars! Enter the car names that will compete together (comma-separated max 5 chars each):")
    val carsInput = Console.readLine()
    val names: List<String> = carsInput.split(",").map{ it.trim() }

    // Validate each name
    validateNames(names)
    return names
}

fun validateNames(names: List<String>) {
    require(names.size >=2) { "Enter at least 2 car names!" }
    require(names.all { it.isNotEmpty() }) { "Car names cannot be empty" }
    require(names.all { it.length <= 5 }) { "Car names cannot have more than 5 characters" }
}

fun getNames(): List<String> {
    // Loop true the name input until the requirements are reached
    while (true) {
        try {
            val names: List<String> = readAndValidateNames()
            return names
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}\nPlease try again.")
        }
    }
}

fun readRoundNumber(): Int {
    // Interactive form for the number of round the race should take:
    println("Now, choose how many rounds the competitors should run:")
    val rounds = Console.readLine().toInt()

    // Validate the number isn't 0 or null
    validateRound(rounds)
    return rounds
}

fun validateRound(number: Int) {
    require(number != 0) { "Number must be greater than zero!" }
}

fun getRound(): Int {
    // Loop true the number input until the requirement is reached
    while (true) {
        try {
            val rounds: Int = readRoundNumber()
            return rounds
        } catch (e: IllegalArgumentException) {
            println("Error: ${e.message}\nPlease try again.")
        }
    }
}

fun main() {
    // TODO: Implement the program
    // Return the validated names
    val carNames = getNames()
    println("The competitors for this race are: $carNames")

    // Return the validate rounds
    val rounds = getRound()
    println("The competitors will run $rounds rounds")
}
