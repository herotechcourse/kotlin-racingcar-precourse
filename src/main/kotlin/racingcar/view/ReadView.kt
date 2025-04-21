package racingcar.view

import camp.nextstep.edu.missionutils.Console

object ReadView {

    private const val NAME_SEPARATOR = ","

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")

        val line = Console.readLine()
            ?: throw IllegalArgumentException("Input cannot be null.")
        require(line.isNotBlank()) { "At least one car name is required." }

        return line.split(NAME_SEPARATOR).map { it.trim() }
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val line = Console.readLine() ?: throw IllegalArgumentException("Round count input is required.")

        return line.toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid number.")
    }

}


