package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun readInput(message: String): String {
    print(message)
    return Console.readLine()
}

fun prompt(message: String): String {
    val input = readInput(message)
    require(input.isNotBlank()) { "Input is empty." }
    return input
}

fun validateCarNames(input: String): List<String> {
    val names = input.split(",").map { it.trim() }
    require(names.all { it.length in 1..5}) {"Each name must be between 1 and 5 chars long"}
    require(names.toSet().size == names.size) {"Car names must be unique."}
    return names
}

fun validateRounds(input: String): Int {
    val rounds = input.toIntOrNull()
    require(rounds != null) { "Input must be a valid number." }
    require(rounds > 0) { "Rounds must be a positive number." }
    return rounds
}

fun printDashes(number: Int): String {
    return "-".repeat(number)
}

fun advanceCars(cars: List<String>, carProgress: MutableMap<String, Int>) {
    cars.forEach { car ->
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber in 4..9) {
            carProgress[car] = (carProgress[car] ?: 0) + 1
        }
    }
}

fun printRaceStatus(cars: List<String>, carProgress: Map<String, Int>) {
    cars.forEach { car ->
        println("$car : ${printDashes(carProgress[car] ?: 0)}")
    }
    println()
}

fun filterWinners(carProgress: Map<String, Int>): List<String>{
    val maxProgress = carProgress.values.maxOrNull()
    return carProgress.filter { it.value == maxProgress }.map {it.key}
}

fun startRace(cars:List<String>, rounds: Int){
    val carProgress = mutableMapOf<String, Int>()
    println("Race Results")
    cars.forEach { car -> carProgress[car] = 0 }
    for (i in 1..rounds) {
        advanceCars(cars, carProgress)
        printRaceStatus(cars, carProgress)
    }
    val winners = filterWinners(carProgress)
    println("Winners : ${winners.joinToString(", ")}")
}

fun main() {
    val namesInput = prompt("Enter names of cars (max 5 chars): e.g. mike,mary,mo: ")
    val cars = validateCarNames(namesInput)

    val roundsInput = prompt("Enter number of rounds to race: ")
    val rounds = validateRounds(roundsInput)
    startRace(cars, rounds)
}
