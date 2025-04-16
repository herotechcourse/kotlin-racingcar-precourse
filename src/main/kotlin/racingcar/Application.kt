package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: Implement the program
    try {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        val carNames = Input.parseCarNames(carNamesInput)
        println("$carNames")

        println("How many rounds will be played?")
        val numberOfRoundsInput = Console.readLine()
        val numberOfRounds = Input.parseNumberOfRounds(numberOfRoundsInput)
        println("$numberOfRounds")

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
