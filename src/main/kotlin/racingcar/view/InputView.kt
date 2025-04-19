package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readCarNames(): String {
        println("Enter the names of the cars (comma-separated):")
        val carNamesInput = Console.readLine()
        return carNamesInput
    }

    fun readRounds(): String {
        println("How many rounds will be played?")
        val roundsInput = Console.readLine()
        return roundsInput
    }
}