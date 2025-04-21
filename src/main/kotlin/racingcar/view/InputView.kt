package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names =  input.split(",").map { it.trim() }
        if (names.isEmpty() || names.any { it.isBlank() }) {
            throw IllegalArgumentException("Car_names_cannot_be_blank_or_empty.")
        }
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("throws_exception_when_attempt_count_is_not_positive")
    }
}