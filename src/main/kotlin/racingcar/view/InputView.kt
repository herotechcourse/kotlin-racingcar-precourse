package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.exception.ExceptionMessage

object InputView{
    fun enterCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input=Console.readLine()
        if(input.isBlank()){
            throw IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAME.message)
        }
        return input.split(",").map{it.trim()}
    }

    fun enterRoundCount():Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val roundCount = input.toIntOrNull()
        if(roundCount == null){
            throw IllegalArgumentException(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }
        require(roundCount > 0) { ExceptionMessage.INVALID_ROUND_COUNT.message }
        return roundCount
    }
}