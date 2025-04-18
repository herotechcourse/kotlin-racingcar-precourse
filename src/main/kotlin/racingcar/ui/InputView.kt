package racingcar.ui

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNames(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }

    fun readRounds(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }
}