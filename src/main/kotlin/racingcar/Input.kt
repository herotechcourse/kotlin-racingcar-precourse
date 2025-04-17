package racingcar

import camp.nextstep.edu.missionutils.Console

class InputParser {
    fun getCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val inputCar = Console.readLine()
        // Convert comma-separated string into clean list
        val carNames = inputCar.split(",").map { it.trim() }

        return carNames
    }

    fun getRounds(): Int {
        println("How many rounds will be played?")
        // Convert string to int
        val inputRounds = Console.readLine().toInt()

        return inputRounds
    }
}