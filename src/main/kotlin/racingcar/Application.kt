package racingcar

import camp.nextstep.edu.missionutils.Console


fun getCars(): List<String> {
    println("Please enter the names of the cars (comma separated):")
    val input = Console.readLine()
    return input.split(",").map { it.trim() }
}

fun getNumberOfRounds(): Int {
    println("Please enter the number of rounds:")
    val input = Console.readLine()
    return input.toInt()
}

fun main() {
    val cars = getCars()
    val rounds = getNumberOfRounds()
}
