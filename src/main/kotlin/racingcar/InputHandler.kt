package racingcar

import camp.nextstep.edu.missionutils.Console

class InputHandler() {

    fun readCarNames() : List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()

        val carNameList: List<String> = input.split(",").map(::validateCarName)
        return carNameList
    }

    fun readRoundNumber() : Int {
        println("How many rounds will be played?")
        val input = Console.readLine()

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("The input must not be blank")
        }

        val number = input.toIntOrNull() ?: throw IllegalArgumentException("The input is not a valid integer")

        if (number <= 0) {
            throw IllegalArgumentException("The input must be a positive integer")
        }

        return number
    }

    fun validateCarName(name: String) : String{
        if (name.length > 5) {
            throw IllegalArgumentException("Car name length is over 5: $name")
        }
        if (name.isBlank()) {
            throw java.lang.IllegalArgumentException("Empty car name is contained")
        }
        return name.trim()
    }
}