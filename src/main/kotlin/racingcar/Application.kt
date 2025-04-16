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
    // To do: Call the function to populate an array of strings containing the car names.
    println("Enter the number of rounds to race:")
    val numberOfRounds = Console.readLine()
}

