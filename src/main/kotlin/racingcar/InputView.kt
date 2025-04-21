package racingcar

// Import Console utility for reading user input
import camp.nextstep.edu.missionutils.Console

// InputView - handles all user input interactions
object InputView {

    // Read and return a list of car names from user input
    fun readCarNames(): List<String> {

        // Prompt user to enter car names
        println("Enter car names (e.g., car1, Car2, car3):")

        // Read input line
        val input = Console.readLine()

        // Handle empty name input
        if (input.isBlank()) {
            throw IllegalArgumentException("Please enter at least one car name.")
        }

        //Print a newline for spacing
        println()

        // Split the input string by commas and trim whitespace
        val names = input.split(",").map { it.trim() }

        // Check: input must contain at least one comma
        if (!input.contains(",")) {
            throw IllegalArgumentException("You must separate car names with commas (e.g., pobi,woni).")
        }

        // Check: no empty names (handles leading/trailing commas or double commas)
        if (names.any { it.isEmpty() }) {
            throw IllegalArgumentException("Car names must not be blank or improperly separated.")
        }

        // Check: all names must be 1–5 characters
        require(names.all { it.length in 1..5 }) {
            "Each car name must be 1 to 5 characters long."
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


