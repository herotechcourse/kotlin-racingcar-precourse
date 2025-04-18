package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val playerNames = getPlayerNames()
    val rounds = getRounds()
    val results = race(playerNames, rounds)
    printResults(results)
}

// Function to get the player names (simulating input)
fun getPlayerNames(): List<String> {
    println("Enter player names (comma separated): ")
    val input = readLine() ?: throw IllegalArgumentException("Player names cannot be empty")
    val names = input.split(",").map { it.trim() }
    
    // Ensure that all player names are 5 characters or fewer
    names.forEach { name ->
        if (name.length > 5) {
            throw IllegalArgumentException("Player name cannot exceed 5 characters")
        }
    }
    
    return names
}


// Function to get the number of rounds (simulating input)
fun getRounds(): Int {
    println("Enter the number of rounds: ")
    val input = Console.readLine() ?: throw IllegalArgumentException("Number of rounds cannot be empty")
    return input.toIntOrNull() ?: throw IllegalArgumentException("Invalid number of rounds")
}

// Function to simulate the racing game logic
fun race(playerNames: List<String>, rounds: Int): List<String> {
    val results = mutableListOf<String>()
    val playerPositions = mutableMapOf<String, Int>()
    
    // Initialize player positions
    playerNames.forEach { player -> playerPositions[player] = 0 }
    
    repeat(rounds) {
        playerNames.forEach { player ->
            val move = Randoms.pickNumberInRange(0, 9) // Simulating movement with random numbers
            if (move >= 4) playerPositions[player] = playerPositions[player]!! + 1
            results.add("$player : ${"-".repeat(playerPositions[player]!!)}")  // Append dashes to represent movement
        }
    }

    // Determine winners based on the highest position
    val maxPosition = playerPositions.values.maxOrNull() ?: 0
    val winners = playerNames.filter { playerPositions[it] == maxPosition }
    results.add("Winners : ${winners.joinToString(", ")}")
    
    return results
}

// Function to print the results of the race
fun printResults(results: List<String>) {
    results.forEach { println(it) }
}
