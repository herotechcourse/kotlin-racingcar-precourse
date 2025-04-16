package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine()
        .split(",")
        .map { it.trim() }

    validateCarNames(carNames)

    println("How many rounds will be played?")
    val roundCount = Console.readLine().toInt()

    val cars = carNames.map { Car(it) }
    val race = Race(cars)

    println("Race Results")
    repeat(roundCount) {
        race.playOneRound { Randoms.pickNumberInRange(0, 9) }
        printRoundResult(race.getCars())
    }

    val winners = race.getWinners().joinToString(",") { it.getName() }
    println("Winners : $winners")
}

fun validateCarNames(names: List<String>) {
    if (names.any { it.isBlank() || it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be non-empty and at most 5 characters long.")
    }
}

fun printRoundResult(cars: List<Car>) {
    for (car in cars) {
        println("${car.getName()} : ${"-".repeat(car.getPosition())}")
    }
    println()
}

