package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val cars = Console.readLine().toCars()

    println("How many rounds will be played?")
    val numberOfRounds = Console.readLine().toNumberOfRounds()

    CarRacing.race(cars, numberOfRounds)
}
