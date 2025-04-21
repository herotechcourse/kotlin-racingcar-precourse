package racingcar.view

import camp.nextstep.edu.missionutils.Console


class InputViewImpl: InputView {
    override fun readCarName(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }

    override fun readRounds(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }
}