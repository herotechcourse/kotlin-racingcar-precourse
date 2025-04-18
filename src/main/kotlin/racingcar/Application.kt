package racingcar

fun main() {
    // Ask user to input car names
    println("Enter the names of the cars (comma-separated): ")
    val input = readLine()
    val carNames = input?.split(",")?.map { it.trim() }?.filter { it.isNotEmpty() }

    // Check if the list is null or empty – there should be at least one car name provided
    if (carNames == null || carNames.isEmpty()) {
        throw IllegalArgumentException("At least one car name must be provided")
    }

    // Check if any car name contains more than 5 characters
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("Car names must not exceed 5 characters")
    }

    // Check for duplicate car names – all names should be unique
    if (carNames.size != carNames.toSet().size) {
        throw IllegalArgumentException("Each car must have a unique name")
    }

    // Ask user to input number of rounds
    println("How many rounds will be played?")
    val noOfRounds = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Input must be an integer")

    // Check if the input is a non-negative integer or not
    if (noOfRounds < 1 ){
        throw IllegalArgumentException("Number of rounds must be a non-negative integer")
    }
}
