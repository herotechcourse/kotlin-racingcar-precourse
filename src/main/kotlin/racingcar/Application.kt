package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program

    //Ask user to input car name/s
    println("Enter the names of the cars (comma-separated):")
    // Read and split input into a list
    val candidates = Console.readLine()!!.split(",")

    // Validate that each name is non-empty and does not exceed 5 characters
    if (candidates.isEmpty() || candidates.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Please provide a valid candidate name")
    }

    //Ask user for number of round/s
    println("How many rounds will be played?")
    // Read and convert input to integer
    val rounds = Console.readLine()!!.toInt()

}
