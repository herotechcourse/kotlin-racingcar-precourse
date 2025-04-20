package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {

    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = validateCarNames(input.split(","))

    println("How many rounds will be played?")
    val rounds = Console.readLine()
    val numberOfRounds: Int = validateRounds(rounds)
    println()

    val cars = names.map { Car(it) }
    val race = Race(cars, numberOfRounds)
    race.startRace()
}

