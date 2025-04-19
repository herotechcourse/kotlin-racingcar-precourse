package racingcar

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.HashMap

fun main() {
    val cars = getAndValidateCars()
    val rounds = getAndValidateRoundNums()
    startGame(rounds, cars)
}

fun getAndValidateCars(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val carsInput = readLine()!! //!!ensures that there's input
    val cars = carsInput.split(",").map { it.trim() }
    validateCarInput(cars)
    return cars
}

fun getAndValidateRoundNums(): Int {
    println("How many rounds will be played?")
    return readLine()!!.toIntOrNull() ?: throw IllegalArgumentException()
}

fun validateCarInput(cars: List<String>) {
    if (cars.isEmpty() || cars.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException()
    }
}

fun startGame(rounds: Int, cars: List<String>) {
    println("\nRace Results")
    val score = HashMap<String, Int>()
    repeat(rounds) {
        runRound(cars, score)
        println()
    }

    announceWinner(score)
}

fun runRound(cars: List<String>, score: HashMap<String, Int>) {  ///calculates and updates the score for each car in current round
    cars.forEach { car ->
        val progress = roundProgress()
        score[car] = (score[car] ?: 0) + progress // for the first round score set it to 0 + the progress
        println("$car : ${"-".repeat(score[car]!!)}")
    }
}

fun announceWinner(score: HashMap<String, Int>) {
    val maxScore = score.values.maxOrNull() ?: 0
    val winners = score.filter { it.value == maxScore }.keys
    println("Winners : ${winners.joinToString(", ")}")
}

fun roundProgress(): Int {
    return if (Randoms.pickNumberInRange(0, 9) >= 4) 1 else 0
}