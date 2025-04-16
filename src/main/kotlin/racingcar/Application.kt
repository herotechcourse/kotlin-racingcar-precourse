package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // UserInput
    val userInput = UserInput()
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine()
        userInput.setCarNamesFromInput(carNames)
    println("How many rounds will be played?")
    val rounds = Console.readLine()
        userInput.setRoundsFromInput(rounds)
    println()

    //Race
    println("Race Results")
    val race = Race()
    race.setCarNames(userInput.carNames)
    race.setRounds(userInput.rounds)
    race.initializeCars()

    while (race.rounds > 0) {
        race.advanceRounds()
    }

    race.announceWinners()
}
