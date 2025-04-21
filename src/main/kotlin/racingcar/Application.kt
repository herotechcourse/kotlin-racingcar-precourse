package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private fun carNameInput(): List<String> {
    val input = Console.readLine()
    return input.split(",")
        .map { it.trim() }
        .onEach { validateCarName(it) }
}

fun validateCarName(name: String) {
    require(name.isNotEmpty()) { "Car name must not be empty." }
    require(name.length <= 5) { "Car name must be at most 5 characters." }
}

fun parseRounds(input: String): Int {
    val num = input.toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number.")
    require(num > 0) { "Rounds must be a positive integer." }
    return num
}

private fun roundsInput() = parseRounds(Console.readLine())

private fun playOneRound(cars: List<Car>) {
    cars.forEach {
        if (Randoms.pickNumberInRange(0, 9) >= 4) it.move()
    }
}

private fun printRoundResult(cars: List<Car>) {
    cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
    println()
}

private fun printWinners(cars: List<Car>) {
    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }
        .joinToString(", ") { it.name }
    println("Winners : $winners")
}

data class Car(val name: String, var position: Int = 0) {
    fun move() { position += 1 }
}

fun main() {
    val carNames = carNameInput()
    val rounds = roundsInput()
    val cars = carNames.map { Car(it) }

    repeat(rounds) {
        playOneRound(cars)
        printRoundResult(cars)
    }

    printWinners(cars)
}