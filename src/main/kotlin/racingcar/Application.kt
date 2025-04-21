package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val names = Console.readLine().split(",").map { it.trim() }
    require(!names.any { !it.matches(Regex("^[A-Za-z]+$")) || it.length > 5 }) { "Invalid name" }

    val rounds = try {
        Console.readLine().toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("Input must be a valid number.")
    }

    require(rounds > 0) { "Invalid number" }

    val results = names.associateWith { 0 }.toMutableMap()

    repeat(rounds) {
        for (name in names) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            results[name] = results[name]!! + 1
            if (randomNumber >= 4) {
                results[name] = results[name]!! + 1
            }
        }
    }

    for ((name, score) in results) {
        println("$name : ${"-".repeat(score)}")
    }

    val maxScore = results.values.maxOrNull()!!
    val winners = results.filter { it.value == maxScore }.keys

    println("Winners : ${winners.joinToString(", ")}")

}
