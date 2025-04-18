package racingcar.io

import camp.nextstep.edu.missionutils.Console
import racingcar.Car

object Input {

    fun promptCarNames(): List<Car> {
        println("Enter the names of the cars (comma-separated): ")
        return InputParser.readCarNames(Console.readLine())
    }

    fun promptNumberOfRound(): Int {
        println("How many rounds will be played? ")
        return InputParser.readRound(Console.readLine())
    }

}