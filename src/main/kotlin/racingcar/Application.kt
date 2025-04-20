package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carsInput = Console.readLine()
    val cars = carsInput.split(",")
    println(cars)
}
