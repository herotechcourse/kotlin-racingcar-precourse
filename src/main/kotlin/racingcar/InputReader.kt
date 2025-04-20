package racingcar

import camp.nextstep.edu.missionutils.Console

object InputReader {
    fun getCarName(): String {
        // Ask user to input car names
        println("Enter the names of the cars (comma-separated): ")
        return Console.readLine() ?: throw IllegalArgumentException("Input cannot be null")
    }

    fun getRound(): Int {
        // Ask user to input number of rounds
        println("How many rounds will be played?")
        return Console.readLine()?.toInt() ?: throw IllegalArgumentException("Input cannot be null")
    }
}
