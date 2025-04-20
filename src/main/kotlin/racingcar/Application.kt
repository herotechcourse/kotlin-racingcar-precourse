package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = readln()
    val cars = parseCarNames(carNamesInput).map { Car(it) }

    println("How many rounds will be played?")
    val roundsInput = readln()
    val rounds = parseRounds(roundsInput)

    println()

    val results = runRace(cars, rounds) {
        Randoms.pickNumberInRange(0, 9) >= 4
    }

    println("Race Results")
    results.forEach { round ->
        println(formatRoundResult(round))
        println()
    }

    val winners = findWinners(results.last())
    println(formatWinners(winners))
}
