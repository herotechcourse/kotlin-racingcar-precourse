package racingcar.view

import camp.nextstep.edu.missionutils.Console

interface Display {
    fun getValidNames(): List<String>
    fun getValidRounds(): Int
}

class ConsoleDisplay : Display {
    private val validator = Validator()

    override fun getValidNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        val errorMsg = validator.validateNames(names)
        if (errorMsg != null) {
            println(errorMsg)
            throw IllegalArgumentException(errorMsg)
        }
        return names
    }

    override fun getValidRounds(): Int {
        println("How many rounds will be played?")
        val roundsInput = Console.readLine()
        val errorMsg = validator.validateRounds(roundsInput)
        if (errorMsg != null) {
            println(errorMsg)
            throw IllegalArgumentException(errorMsg)
        }
        return roundsInput!!.toInt()
    }

}