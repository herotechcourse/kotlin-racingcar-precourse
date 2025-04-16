package racingcar

fun main() {
    // TODO: Implement the program
    val carNames = readCarNames()
    println("Car names: $carNames")
}

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = readLine() ?: throw IllegalArgumentException("Input cannot be null")
    val names = input.split(",").map { it.trim() }

    if (names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Each name must be 1 to 5 characters long.")
    }

    return names
}