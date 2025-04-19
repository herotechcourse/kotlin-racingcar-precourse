package racingcar

fun main() {
 try {
     println("Enter the names of the cars (comma-separated):")

     // Array of car names
     val inputNames = readln().split(",").map { it.trim() }

     // Creating car objects depending upon the array
     val cars = inputNames.map { Car(it) }

     // Validating rounds
     println("How many rounds will be played?")
     val rounds = readln().toInt()
     require(rounds > 0) { "Number of rounds must be positive." }

     // Race object with the list of cars and number of rounds
     val race = Race(cars, rounds)

     // Start the race
     race.startRace()

     // Print Winners
     race.printWinners()
    } catch (e: IllegalArgumentException) {
        // This catch block handles any IllegalArgumentException (e.g., invalid car names or rounds)
        println("Error: ${e.message}")
    } catch (e: Exception) {
        // This catch block handles any other unexpected errors (e.g., non-integer input for rounds)
        println("Unexpected error: ${e.message}")
    }
}
