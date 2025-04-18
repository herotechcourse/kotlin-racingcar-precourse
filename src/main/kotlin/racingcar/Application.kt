package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }

    validateCarNames(carNames)

    println("How many rounds will be played?")
    val roundInput = Console.readLine()
    val rounds = validateRoundCount(roundInput)

    val cars = carNames.map { Car(it) }
    val race = Race(cars, rounds)
    race.start()
}
