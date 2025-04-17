package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames: List<String> = ParseAndValidate.parseAndValidateNames(carNamesInput)
}
