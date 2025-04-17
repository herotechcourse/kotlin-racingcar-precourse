package racingcar
import camp.nextstep.edu.missionutils.Console

fun getNumberOfRounds(): Int {
    val input = readRoundInput()
    return parseRoundInput(input)
}

fun readRoundInput(): String {
    println("How many rounds will be played?")
    return Console.readLine()
}

fun parseRoundInput(input: String): Int {
    if (input.isBlank()) {
        throw IllegalArgumentException("Round input cannot be blank.")
    }

    val number = input.toIntOrNull()
        ?: throw IllegalArgumentException("Round input must be a valid number.")

    if (number <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than zero.")
    }

    return number
}