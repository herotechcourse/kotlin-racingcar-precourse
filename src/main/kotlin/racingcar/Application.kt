package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program

    // Ask user to input car name/s
    println("Enter the names of the cars (comma-separated):")
    // Read and split input into a list
    val candidates = Console.readLine()!!.split(",")

    // Validate that each name is non-empty and does not exceed 5 characters
    if (candidates.isEmpty() || candidates.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Please provide a valid candidate name")
    }

    // Ask user for number of round/s
    println("How many rounds will be played?")
    // Read and convert input to integer
    val rounds = Console.readLine()!!.toInt()

    // Print a header before race starts
    println("Race Results")

    // Initialize a map to track how many times each candidate moves forward
    val candidatesMapping = mutableMapOf<String, Int>()

    // Start each candidate with a score of 0
    for (name in candidates) {
        candidatesMapping[name] = 0
    }

    // Repeat for the given number of rounds
    for (i in 0 until rounds) {
        for (candidate in candidatesMapping.keys) {
            updateCandidate(candidate, candidatesMapping)
        }
    }

    // After all rounds, find the highest score
    val maxCount = candidatesMapping.values.maxOrNull() ?: 0

    // Filter out all candidates who have the max score (supporting multiple winners)
    val winners = candidatesMapping.filterValues { it == maxCount }.keys

    // Join the winners into a single string and print the result
    val winnersList = winners.joinToString(", ")
    println("Winners : $winnersList")
}

// Updates one candidate's position based on a random value
fun updateCandidate(candidate: String, candidatesMapping: MutableMap<String, Int>) {
    // Generate a random number between 0 and 9
    val random = Randoms.pickNumberInRange(0, 9)

    // If the number is ≥ 4, move the car forward by incrementing its score
    if (random >= 4) {
        candidatesMapping[candidate] = candidatesMapping[candidate]!! + 1
    }

    // Print the candidate's progress as dashes
    println("$candidate : ${"-".repeat(candidatesMapping[candidate]!!)}")
}

