package racingcar

// Import Console utility for reading user input
import camp.nextstep.edu.missionutils.Console

// InputView - handles all user input interactions
object InputView {

    // Read and return a list of car names from user input
    fun readCarNames(): List<String> {

        // Prompt user to enter car names
        println("Enter car names (e.g., car1, Car2, car3):")

        // Read input line and print a newline for spacing
        val input = Console.readLine()
        println()

        // Split the input string by commas and trim whitespace
        val names = input.split(",").map { it.trim() }

        // Validate that all names are not empty and up to 5 characters
        require(names.all { it.isNotBlank() && it.length <= 5}) {
            "Each car name must be not empty and up to 5 characters."
        }

        return names

    }

    // Read and return the number of rounds from user input
    fun readRoundCount(): Int {

        // Prompt user to enter the number of rounds
        println("How many rounds?")

        // Read input and convert to integer if valid
        return Console.readLine().toIntOrNull()?.also {

            // Validate that the number is positive
            require(it > 0) { "Number of rounds must be positive." }

        // If input is not a valid number, throw an error with a message
        } ?: throw IllegalArgumentException("Please enter a valid number.")

        }

    }


