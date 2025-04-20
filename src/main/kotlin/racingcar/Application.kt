package racingcar

// Interface to abstract input handling, making the code testable and flexible
interface InputHandler {
    fun readLine(): String
}

// Implementation of InputHandler that reads input from the console
class ConsoleInputHandler : InputHandler {
    override fun readLine(): String {
        return camp.nextstep.edu.missionutils.Console.readLine()
    }
}

fun main() {
    // Create an instance of ConsoleInputHandler to handle user input
    val inputHandler = ConsoleInputHandler()

    try {
        // Step 1: Input Handling
        // Get car names and number of rounds from the user
        val carNames = getCarNames(inputHandler)
        val rounds = getNumberOfRounds(inputHandler)

        // TODO: Proceed to car movement logic
        println("Car names: $carNames")
        println("Number of rounds: $rounds")
    } catch (e: IllegalArgumentException) {
        // Handle invalid input by displaying an error message
        println("Error: ${e.message}")
    }
}

// Function to get and validate car names from the user
fun getCarNames(inputHandler: InputHandler): List<String> {
    println("Enter car names (comma-separated):")
    val carNames = inputHandler.readLine().split(",").map { it.trim() }
    // Validate that each car name is non-empty and at most 5 characters long
    if (carNames.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be non-empty and at most 5 characters long.")
    }
    return carNames
}

// Function to get and validate the number of rounds from the user
fun getNumberOfRounds(inputHandler: InputHandler): Int {
    println("Enter the number of rounds:")
    val rounds = inputHandler.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("Number of rounds must be a valid integer.")
    // Validate that the number of rounds is greater than 0
    if (rounds <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0.")
    }
    return rounds
}