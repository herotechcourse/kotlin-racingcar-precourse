package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine();
        val names = input.split(",").map {it.trim()}

        if(names.any {it.isBlank() || it.length > 5 }){
            throw IllegalArgumentException("Each car name must be 1~5 characters and not blank.")
        }
        return names
    }
    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val cnt = input.toIntOrNull()
            ?: throw IllegalArgumentException("Round count must be a number.")

        if (cnt <= 0) {
            throw IllegalArgumentException("Round count must be greater than 0.")
        }
        return cnt
    }
}