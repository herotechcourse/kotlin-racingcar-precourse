package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var cars: List<String> = emptyList()
var rounds: Int = 0
var move: Boolean = false

fun main() {
    validateCarName()
    rounds = inputRoundCount()
    println(movement())

}

fun inputCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val cars = Console.readLine()
    return cars.split(",").map { it.trim() }
}

fun validateCarName() {
    cars = inputCarNames()
    for (i in cars) {
        if (i.length > 5){

     throw IllegalArgumentException("Car name cannot be more than 5 characters")
        }
    }
    return
}

fun inputRoundCount(): Int {
    println("How many rounds will be played?")
    val rounds = Console.readLine()
    return rounds.toIntOrNull() ?: 0
}

fun movement(): Boolean {
    val randomValue = Randoms.pickNumberInRange(0, 9)
    if (randomValue >= 4) {
        move = true}
    return move
}