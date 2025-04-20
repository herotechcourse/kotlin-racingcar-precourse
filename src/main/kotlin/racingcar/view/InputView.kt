package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        require(
            names.isNotEmpty() &&
                    names.all { it.isNotBlank() && it.length <= 5 }
        ) {
            "Car names must be non-empty and up to 5 characters."
        }
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val count = input.toIntOrNull()
        require(count != null && count > 0) {
            "Number of rounds must be a positive integer."
        }
        return count
    }
}
