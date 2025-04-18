package racingcar.view

import camp.nextstep.edu.missionutils.Console

object GameView{

    fun readCarNames(): List<String>{
        println(" Enter names of the cars (comma-seperated): ")
        val input = Console.readLine()
        return input.split(",")
    }

    fun readRounds(): Int{
        println("Enter the number of rounds: ")
        val number = Console.readLine().toIntOrNull()
        require(number != null && number > 0){ " Round count must be positive"}
        return number
    }
}