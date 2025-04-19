package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String) {
    var position: Int = 0
    
    fun move(shouldMove: Boolean) {
        if (shouldMove) position++
    }
}

fun main() {
    val cars = createCars()
    val rounds = getRounds()
    startRace(cars, rounds)
    announceWinners(cars)
}

private fun createCars(): List<Car> {
    println("Enter the names of the cars (comma-separated):")
    val names = Console.readLine().split(",").map { it.trim() }
    validateNames(names)
    return names.map { Car(it) }
}

private fun validateNames(names: List<String>) {
    require(names.isNotEmpty()) { "At least one car name is required" }
    names.forEach {
        require(it.isNotBlank()) { "Empty car name is not allowed" }
        require(it.length <= 5) { "Name '$it' exceeds 5 characters" }
    }
    require(names.size == names.toSet().size) { "Duplicate car names are not allowed" }
}

private fun getRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Invalid number format")
    require(rounds > 0) { "Rounds must be greater than 0" }
    return rounds
}

private fun startRace(cars: List<Car>, rounds: Int) {
    println("\nRace Results\n")
    repeat(rounds) {
        playRound(cars)
        printProgress(cars)
    }
}

private fun playRound(cars: List<Car>) {
    cars.forEach { car ->
        car.move(Randoms.pickNumberInRange(0, 9) >= 4)
    }
}

private fun printProgress(cars: List<Car>) {
    cars.forEach {
        println("${it.name} : ${"-".repeat(it.position)}")
    }
    println()
}

private fun announceWinners(cars: List<Car>) {
    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.map { it.name }
    println("Winners : ${winners.joinToString(", ")}")
}