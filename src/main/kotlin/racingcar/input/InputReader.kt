package racingcar.input

import camp.nextstep.edu.missionutils.Console

class InputReader {

    fun readAndGetCarNames(): List<String>{
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        require (carNamesInput.isNotEmpty()) { "Car names must not be empty" }
        val carNamesList = carNamesInput.split(",").map { it.trim()}

        require(carNamesList.size == carNamesList.distinct().size) { "Car names must be unique" }
        carNamesList.forEach {
            require(it.length <= 5) { "CarName exceeds 5 characters" }
        }
        return carNamesList
    }

    fun readAndGetRounds(): Int{
        println("How many rounds will be played?")
        val numberOfRounds = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("Rounds must not be empty")
        require(numberOfRounds > 0) {"Rounds should be greater than 0"}
        return numberOfRounds
    }
}