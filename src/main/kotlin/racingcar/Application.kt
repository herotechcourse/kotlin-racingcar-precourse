package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames: List<String> = ParseAndValidate.parseAndValidateNames(carNamesInput)
    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val rounds = ParseAndValidate.parseAndValidateRounds(roundsInput)
    val cars = carNames.map { Car(it) }
    val race = Race(cars)
    println("\nRace Results")
    repeat(rounds) {
        race.runRound()
        race.printProgress()
    }
    val winners = race.getWinners()
    println("Winners : ${winners.joinToString(", ")}")
}
