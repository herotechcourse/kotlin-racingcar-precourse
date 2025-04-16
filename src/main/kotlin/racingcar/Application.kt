package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println(
        buildString {
            append("Enter the names of the cars. Make sure to:\n- Separate them by a comma and no spaces.")
            append("\n- Use less than five characters per car name.")
        },)
    val carNames = Console.readLine()
    // To do: Call a function that validates the input.
    println("Enter the number of rounds to race:")
    val numberOfRounds = Console.readLine()

    // To test the carSeparator function
    //   val separatedCarNames = carSeparator(carNames)
    //   println(separatedCarNames)
}

fun carSeparator(carNames: String): List<String> {
    val listOfCars = carNames.split(",").map { it.trim() }
    return listOfCars
}