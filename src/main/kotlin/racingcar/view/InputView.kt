package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return input.split(",").map { it.trim() }
    }

    fun getTotalRound(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }
}