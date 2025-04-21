package racingcar

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
}
