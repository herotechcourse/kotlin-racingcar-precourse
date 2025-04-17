package racingcar


import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    print("Enter names of cars (max 5 chars):e.g mike,mary,mo")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }
    names.forEach { name ->
        println(name)
    }
}