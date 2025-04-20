package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.input.RaceInputHandler

object InputView {
    fun readCarNames(): String {
        print("Enter the names of the cars (comma-separated, each name 1-5 characters): ")
        val input = Console.readLine()
        RaceInputHandler.validateCarNames(input)
        return input
    }

    fun readRounds(): String{
        print("Enter the number of rounds for the race: ")
       return Console.readLine()

    }
}