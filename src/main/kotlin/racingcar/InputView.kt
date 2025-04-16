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
}


