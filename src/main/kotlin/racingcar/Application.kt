package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var cars: List<String> = emptyList()
var rounds: Int = 0

fun main() {
    // Populate the global cars and rounds variables
    cars = inputCarNames()
    rounds = inputRoundCount()
    // Example usage of Randoms.pickNumberInRange()
    val randomValue = Randoms.pickNumberInRange(0, 9)
    println("Random value: $randomValue")
}

fun inputCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val cars = Console.readLine()
    return cars.split(",").map { it.trim() }
}

fun inputRoundCount(): Int {
    println("How many rounds will be played?")
    val rounds = Console.readLine()
    return rounds.toIntOrNull() ?: 0
}

fun movement(): Boolean {
    val randomValue = Randoms.pickNumberInRange(0, 9)
    if (randomValue >= 4);
        return true
}