package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine().split(",")
    for (car in carNames) {
        validateNamesLength(car)
        validateEmptyNames(car)
    }
    println(carNames)
    println("How many rounds will be played?")
    val rounds = Console.readLine().toIntOrNull()
    validateRounds(rounds)
    println(rounds)
}
