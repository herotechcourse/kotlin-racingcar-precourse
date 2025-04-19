package racingcar.view

import camp.nextstep.edu.missionutils.Console

fun readCarNames(): List<String> {
    println("Enter car names (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }
    require(names.isNotEmpty() && names.all { it.isNotBlank() && it.length <= 5 }) {
        "Car names must be non-empty and up to 5 characters."
    }
    return names
}