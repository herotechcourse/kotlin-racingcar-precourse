package racingcar

object Output {
    fun printCarNameInputMessage() = println("Enter the names of the cars (comma-separated):")

    fun printRoundInputMessage() = println("How many rounds will be played?")

    fun printRaceStartMessage() = println("\nRace Results")

    fun printProgress(cars: List<Car>) = println(cars.joinToString("\n") + "\n")

    fun printWinners(winners: List<Car>) = println("Winners : ${winners.joinToString(", ") { it.name }}")
}