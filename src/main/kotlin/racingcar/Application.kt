package racingcar

import camp.nextstep.edu.missionutils.Console

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",")
    val isInvalid = names.any { it.isBlank() || it.length > 5 }

    if (isInvalid) {
        throw IllegalArgumentException("Each car name must be 1–5 characters long.")
    }
    return names
}

fun main() {
    readCarNames()
}
