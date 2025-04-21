package racingcar.services

import camp.nextstep.edu.missionutils.Console

class ReaderService(private val readerService: ConsoleReaderService) {
    fun readCarsNames(): List<String> {
        val names = readerService.readLine().split(",").map { it.trim() }
        require(!names.any { !it.matches(Regex("^[A-Za-z]+$")) || it.length > 5 }) { "Invalid name" }
        return names
    }

    fun readRounds(): Int {
        try {
            val rounds = Console.readLine().toInt()
            require(rounds > 0) { "Invalid number" }
            return rounds
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Input must be a valid number.")
        }
    }
}