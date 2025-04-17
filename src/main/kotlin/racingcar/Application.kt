package racingcar


import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    print("Enter names of cars (max 5 chars):e.g mike,mary,mo")
    val input = Console.readLine()
    if (input.isNullOrBlank()) {
        throw IllegalArgumentException("Input is Empty")
    }
    val names = input.split(",").map { it.trim() }
    names.forEach { name ->
        if (name.length !in 1..5) {
            throw IllegalArgumentException("Name must be between 1 and 5")
        }
    }
    names.forEach { name ->
        println(name)
    }
}