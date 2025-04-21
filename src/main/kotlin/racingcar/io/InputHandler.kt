package racingcar.io

import camp.nextstep.edu.missionutils.Console

class InputHandler {
    fun getCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        return carNamesInput.split(",").map { it.trim() }
    }

    fun getRounds(): Int {
        println("How many rounds will be played?")
        val roundsInput = Console.readLine()
        return roundsInput.toInt()
    }
}