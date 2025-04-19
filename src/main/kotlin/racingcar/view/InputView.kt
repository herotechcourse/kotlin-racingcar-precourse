package racingcar.view

import camp.nextstep.edu.missionutils.Console


object InputView {
    fun readCarNames(): List<String> {
        println("Input car names separated by commas:")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        Validator.validateCarNames(names)
        return names
    }
}