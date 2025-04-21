package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.core.RaceCore
import racingcar.repository.CarRepository

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val names = Console.readLine()
    println("How many rounds will be played?")
    val rounds = Console.readLine().toInt()

    val raceCore = RaceCore(names, rounds, CarRepository())

    raceCore.run()
}
