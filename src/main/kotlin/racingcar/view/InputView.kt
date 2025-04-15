package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun readNames(): List<String>{
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        return names
    }

    fun readRounds(): Int{
        println("How many rounds will be played?")
        val input = Console.readLine()
        return input.toInt()
    }
}