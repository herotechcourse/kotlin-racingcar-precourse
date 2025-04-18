package racingcar

fun main() {

    println("Enter the names of the cars (comma-separated):")

    // Array of car names
    val inputNames = readln().split(",").map { it.trim() }

    // Creating car objects depending upon the array
    val cars = inputNames.map { Car(it) }

    println("How many rounds will be played?")
    val rounds = readln().toInt()
    require(rounds > 0) { "Number of rounds must be positive." }

}
