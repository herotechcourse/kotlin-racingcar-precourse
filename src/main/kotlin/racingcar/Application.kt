package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val userInput = obtainUserInput()
    printRaceResultsHeader()
    val race = setupRace(userInput)
    race.run()
    race.announceWinners()
}

fun obtainUserInput(): UserInput {
    val userInput = UserInput()
    obtainCarNames(userInput)
    obtainRounds(userInput)
    return userInput
}

fun obtainCarNames(userInput: UserInput) {
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine()
    userInput.setCarNamesFromInput(carNames)
}

fun obtainRounds(userInput: UserInput) {
    println("How many rounds will be played?")
    val rounds = Console.readLine()
    userInput.setRoundsFromInput(rounds)
}

fun printRaceResultsHeader() {
    println()
    println("Race Results")
}

fun setupRace(userInput: UserInput): Race {
    val race = Race()
    race.setCarNames(userInput.carNames)
    race.setRounds(userInput.rounds)
    race.initializeCars()
    return race
}