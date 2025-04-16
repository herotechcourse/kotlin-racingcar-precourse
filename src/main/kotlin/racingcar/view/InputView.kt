package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Validator

object InputView {

    fun readNames(): List<String>{
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        Validator.validateNames(names)
        return names
    }

    fun readRoundNumber(): Int{
        println("How many rounds will be played?")
        val input = Console.readLine()
        return Validator.validateRoundNumber(input)
    }
}