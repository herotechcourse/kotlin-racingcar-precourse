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
    val names: List<String> = readAndValidateNames() // Calls Step 2
    // if names matched all required rules, it returns the names
    return names

}

// Step 5: ask user input for the number of rounds and validate it by calling Step 6
fun readRoundNumber(): Int {
    // Interactive form for the number of rounds the race should take:
    println("Now, choose how many rounds the competitors should run:")
    val roundsInput = Console.readLine()

    // Validates if the input is a number and greater than 0
    validateRoundInput(roundsInput)

    return roundsInput.toInt()
}

fun validateRoundInput(input: String) {
    val integerChars = '0'..'9'
    val result = input.all { it in integerChars }
    require(result) { "Invalid round number!" }
    require(input.toInt() != 0) { "Number must be greater than zero!" }
}

// Step 4: take a integer number by calling the readRoundNumber - Step 5
fun getRound(): Int {
    // gets validated Input
    val rounds: Int = readRoundNumber() // Calls Step 5

    return rounds
}

// Create a class to save the competitors progress
class Competitor(val name: String) {
    var position: Int = 0

    // each competitor is responsible for their owm progress
    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9) // pick a random number
        val shouldMove = randomNumber >= 4 // check if the number represents a movement

        if (shouldMove) {
            position++  // Adds 1 to the current position
        }
    }

    // each competitor will display their own results
    fun printPosition() {
        print("$name : ")
        repeat(position) { print("-") }
        println()
    }
}

// Runs the game logic
fun startRace(rounds: Int, competitors: List<Competitor>) {
    // Repeat the number of rounds
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

// Compare competitors positions to define winner(s)
fun getWinners(competitors: List<Competitor>): List<Competitor> {
    // Sort competitors to be in the order of the best results
    val competitorsSortedByPosition = competitors.sortedByDescending { competitor -> competitor.position }
    // The first best result is already considered a winner
    val firstWinner = competitorsSortedByPosition.first()
    val winners = mutableListOf(firstWinner)

    // Check for tie results
    for (i in competitorsSortedByPosition.indices) {
        val current = competitorsSortedByPosition[i]

        // Ensure it will check only in the range of the list
        if (i < competitors.size - 1) {
            val next = competitorsSortedByPosition[i + 1]

            if (current.position == next.position) {
                winners += next

            } else {
                // If the number of the next position check is differs from the winner(s)
                // stop checking
                break
            }
        }

    }
    return winners
}

fun main() {
    // TODO: Implement the program

    // ---> USER FEATURES <---
    // Return the validated names
    val carNames = getNames()
    println("The competitors for this race are: $carNames")

    // Return the validate rounds
    val rounds = getRound()
    println("The competitors will run $rounds rounds")

    // ---> GAME FEATURES <---
    // Save the car names as instances of the Competitors constructor.
    val competitors = carNames.map { Competitor(it) }

    // Calls the logic to run the game
    startRace(rounds, competitors)

    // ---> GAME TRACKER FEATURES <---
    // Get the winners
    val winners = getWinners(competitors)

    // Get winners names to be printed
    val winnerNames = winners.map { winner -> winner.name }

    // Print Winners:
    println("Winners : ${winnerNames.joinToString { it }}")
}