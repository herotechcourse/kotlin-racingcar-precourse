package racingcar

import camp.nextstep.edu.missionutils.Console

class InputHandler() {

    fun readCarNames() : List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()

        val carNameList: List<String> = input.split(",").map(::validateCarName)
        return carNameList
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