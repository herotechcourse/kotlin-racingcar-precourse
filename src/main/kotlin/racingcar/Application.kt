package racingcar

import racingcar.validation.*

fun main() {
    // Read User Input
    val userInput = readUserInput()

    // Process the user input
    val validCarNames = processUserInput(userInput)

    // Print the valid car names
    println(validCarNames)
}
