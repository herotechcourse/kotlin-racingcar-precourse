package racingcar

import camp.nextstep.edu.missionutils.Console

object Input {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return Validator.validateCarNames(input)
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return Validator.validateRounds(input)
    }
}