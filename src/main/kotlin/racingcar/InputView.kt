package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",")
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .distinct()
        if (names.any { it.length > 5 }) throw IllegalArgumentException("Car name too long")
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        return Console.readLine().toInt()
    }
}
