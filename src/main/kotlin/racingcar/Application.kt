package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// Step 2: ask user input for the names and validate them by calling Step 3
fun readAndValidateNames(): List<String> {
    // Interactive form for user's car name input:
    println("Welcome to Racing Cars! Enter the car names that will compete together (comma-separated max 5 chars each):")
    val carsInput = Console.readLine()
    val names: List<String> = carsInput.split(",").map { it.trim() }

    // Validate each name
    validateNames(names) // calling Step 3
    return names
}

// Step 3: validate all names by checking the logic requirements
// if they aren't a match for any requirement, it sends a correction warning message
fun validateNames(names: List<String>) {
    require(names.size >= 2) { "Enter at least 2 car names!" }
    require(names.all { it.isNotEmpty() }) { "Car names cannot be empty" }
    require(names.all { it.length <= 5 }) { "Car names cannot have more than 5 characters" }
}

// Step 1: take a list of names to see if they are
// valid names by calling the input function - Step2
fun getNames(): List<String> {
    // Loop true the name input until the requirements are reached
    while (true) {
        try {
            val names: List<String> = readAndValidateNames() // Calls Step 2
            // if names matched all required rules, it returns the names
            return names
        } catch (e: IllegalArgumentException) {
            // if names doesn't match any requirement, it prints the error
            println("Error: ${e.message}\nPlease try again.")
        }
    }
}

// Step 5: ask user input for the number of rounds and validate it by calling Step 6
fun readRoundNumber(): Int {
    // Interactive form for the number of round the race should take:
    println("Now, choose how many rounds the competitors should run:")
    val rounds = Console.readLine().toInt()

    // Validate the number isn't 0 or null
    validateRound(rounds) // Calls Step 6
    return rounds
}

// Step 6: validate the number entered by checking the logic requirement
// if the requirement isn't matched, it sends a correction warning message
fun validateRound(number: Int) {
    require(number != 0) { "Number must be greater than zero!" }
}

// Step 4: take a integer number by calling the input function - Step 5
fun getRound(): Int {
    // Loop true the number input until the requirement is reached
    while (true) {
        try {
            val rounds: Int = readRoundNumber() // Calls Step 5
            // if it matches the requirement it returns the number
            return rounds
        } catch (e: IllegalArgumentException) {
            // if the number doesn't match the requirement, it prints the error
            println("Error: ${e.message}\nPlease try again.")
        }
    }
}

fun main() {
    // TODO: Implement the program

    // USER FEATURES
    // Return the validated names
    val carNames = getNames()
    println("The competitors for this race are: $carNames")

    // Return the validate rounds
    val rounds = getRound()
    println("The competitors will run $rounds rounds")

    // GAME FEATURES
    // Create a class to save the competitors progress
    class Competitor(val name: String) {
        var position: Int = 0

        fun move() {
            val randomNumber = Randoms.pickNumberInRange(0, 9) // pick a random number
            val shouldMove = randomNumber >= 4 // check if the number represents a movement

            if (shouldMove) {
                position++  // Adds 1 to the current position
            }
        }

        fun printPosition() {
            print("$name : ")
            repeat(position) { print("-") }
            println()
        }
    }

    // Save the car names as instances of the Competitors constructor.
    val competitors = carNames.map { Competitor(it) }

    // Function to print the cars progress in each round
    repeat(rounds) { round ->
        // Iterates with each competitor instance
        competitors.forEach { competitor ->
            competitor.move() // calls the instance move method to move the car
            competitor.printPosition() // calls the instance print method to update user of the progress
        }
        // Prints an empty line to separate each round on the console
        println()
    }

}