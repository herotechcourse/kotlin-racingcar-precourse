package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine().split(",")
    }
}