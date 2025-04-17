package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val carNames = readCarNames()
        val roundCount = readRoundCount()
        println("Round count: $roundCount") // Temporary debug output
    }

    private fun readCarNamesInput(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }

    private fun readCarNames(): List<String> {
        val input = readCarNamesInput().trim()
        val names = input.split(",").map { it.trim() }

        if (names.isEmpty() || names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be 1–5 characters.")
        }

        return names
    }

    private fun readRoundCountInput(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }

    private fun readRoundCount(): Int {
        val input = readRoundCountInput().trim()
        return input.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
    }
}