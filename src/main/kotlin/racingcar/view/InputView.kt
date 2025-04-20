package racingcar.view

import camp.nextstep.edu.missionutils.Console


object InputView {

    fun inputCarName(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }

    fun inputPlayRound(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }
}