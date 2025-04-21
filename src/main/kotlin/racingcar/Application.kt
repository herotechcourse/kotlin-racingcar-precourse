package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine().split(",")

    println("How many rounds will be played?")
    val roundInput = Console.readLine()

    println("Car Names: ${carNamesInput[0]}, ${carNamesInput[1]}, ${carNamesInput[2]}")
    println("Racing Round: $roundInput Round")
}
