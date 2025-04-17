package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    ValidationUtils.checkEmpty(carNamesInput)
    val carNames = carNamesInput
                    .split(",")
                    .map { it.trim() }
                    .onEach  { ValidationUtils.requireValidName(it) }
}
