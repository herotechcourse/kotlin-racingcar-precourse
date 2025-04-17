package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun inputCarNames(): List<String> {
    print("Enter the names of the cars (comma-separated): ")
    val userInput = Console.readLine()
    val carNames = userInput.split(",").map { it.trim() }

    carNames.forEach {
        require(it.isNotEmpty()) { "Each car must have a name." }
        require(it.length <= 5) { "Car name must not exceed 5 characters." }
    }

    return carNames
}

fun inputRoundNum(): Int {
    print("How many rounds will be played? ")
    val userInput = Console.readLine()
    val round = userInput.toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid number.")

    require(round > 0) { "Round must be greater than 0." }

    return round
}



fun main() {
    val carNames = inputCarNames()
    val round = inputRoundNum()

    val cars= carNames.map{ Car(it)}
    repeat(round){
        cars.forEach {it.move()}
        cars.forEach { it.printPosition() }
        println()
    }
    println("Car Names: ${carNames.joinToString(", ")}")
    println("Number of Rounds: $round")

}
