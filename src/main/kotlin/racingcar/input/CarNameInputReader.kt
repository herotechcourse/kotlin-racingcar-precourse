package racingcar.input

import camp.nextstep.edu.missionutils.Console

class CarNameInputReader {
    fun read(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }
}