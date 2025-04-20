package racingcar.io
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): String{
        println("Enter the name of the cars (comma-seperated):")
        return Console.readLine()
    }

    fun readNumberOfRounds(): String{
        println("Enter the number of rounds:")
        return Console.readLine()
    }
}