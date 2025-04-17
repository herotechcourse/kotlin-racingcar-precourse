package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.io.File

fun main() {
    // TODO: Implement the program
    val carNames = inputCarNames()
    val cars = carNames.map { Car(it) }
    val rounds = inputRounds()
    val outputBuilder = StringBuilder()

    outputBuilder.appendLine("\nRace Results")
    repeat(rounds) {
        cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
        cars.forEach { outputBuilder.appendLine("${it.name} : ${it.positionBar()}") }
        outputBuilder.appendLine()
    }

    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
    outputBuilder.appendLine("Winners : $winners")

    println(outputBuilder.toString()) // Show in Run console
    saveOutputToFile(outputBuilder.toString()) // Save in a file
}

fun inputCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }
    if (names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be 1-5 characters long.")
    }
    return names
}

fun inputRounds(): Int {
    println("How many rounds will be played?")
    return Console.readLine().toInt()
}

fun saveOutputToFile(output: String) {
    val file = File("race_output.txt")
    file.writeText(output)
}