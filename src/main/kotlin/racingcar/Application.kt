package racingcar
import camp.nextstep.edu.missionutils.Console

fun getNames(): List<String> {
    println("Please enter names of the cars separated by comma: ")

    // Read input, split by comma, trim whitespace from each name
    val cars = Console.readLine().split(",").map { it.trim() } // learned I can use split method and map on the same variable

    // Validate: names must not be empty and must be 5 chars max
    if (cars.isEmpty() || cars.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("All cars must have a name up to 5 characters each")
    }
    return cars
}

fun getRounds(): Int {
    println("Please enter number of rounds: ")

    // Try converting input to integer; returns null on failure
    val rounds = Console.readLine().toIntOrNull()

    if (rounds == null || rounds < 1 ) {
        throw IllegalArgumentException("Rounds must a positive integer")
    }
    return rounds
}

fun main() {
    // Directly printing results of input functions
    println(getNames())
    println(getRounds())
}