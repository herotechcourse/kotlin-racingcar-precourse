package racingcar.view

import racingcar.util.InputValidator

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = readLine() ?: throw IllegalArgumentException("input is Null.")
        val names = input.split(",").map { it.trim() }
        InputValidator.validateCarNames(names)
        return names
    }

    fun readNumOfRounds(): Int {
        println("How many rounds will be played?")
        val input = readLine() ?: throw IllegalArgumentException("input is Null.")
        return InputValidator.validateRoundCnt(input)
    }
}