package racingcar

import camp.nextstep.edu.missionutils.Console

object InputHandler {
    fun parseCarNames(raw: String): List<String> {
        if (raw.isBlank()) throw IllegalArgumentException("Car names must not be empty.")
        return raw.split(",")
            .map { it.trim() }
            .onEach {
                require(it.isNotEmpty() && it.length <= 5) {
                    "Each car name must be 1–5 characters: '$it'"
                }
            }
    }

    fun parseRoundCount(raw: String): Int {
        val num = raw.trim().toIntOrNull()
            ?: throw IllegalArgumentException("Rounds must be a positive integer.")
        require(num > 0) { "Rounds must be greater than zero." }
        return num
    }

    // I/O wrappers
    fun readCarNames(): List<String> {
        println("Enter car names (comma-separated):")
        return parseCarNames(Console.readLine())
    }

    fun readRoundCount(): Int {
        println("Enter number of rounds:")
        return parseRoundCount(Console.readLine())
    }
}
