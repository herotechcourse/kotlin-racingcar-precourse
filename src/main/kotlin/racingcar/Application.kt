package racingcar

fun main() {
    val validator = Validator()
    val input = Input(validator)
    val round = Round()
    val output = Output(round)

    println("Enter the names of the cars (comma-separated):")
    val cars = input.enterCarNames()

    println("How many rounds will by played?")
    val roundCount = input.enterRoundCount()

    println("\nRace Results")
    output.printCarRaceResults(cars, roundCount)
    output.printWinners(cars)
}
