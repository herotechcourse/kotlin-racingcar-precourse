package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val names = Console.readLine().split(",").map { it.trim() }
    if (names.any {!it.matches(Regex("^[A-Za-z]+$")) || it.length > 5 }) {
        throw IllegalArgumentException("Invalid name")
    }

    val rounds = Console.readLine().toInt()

    val results = mutableMapOf<String, Int>()

    for (name in names) {
        results[name] = 0
    }

    repeat(rounds) {
        for (name in names) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
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
