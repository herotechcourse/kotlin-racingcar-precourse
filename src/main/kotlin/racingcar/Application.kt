package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine().split(",")
    println(carNames)
    println("How many rounds will be played?")
    val rounds = Console.readLine().toIntOrNull()
    println(rounds)
}
