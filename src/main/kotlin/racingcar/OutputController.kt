package racingcar

object OutputController {
    private const val ENTER_THE_NAMES_OF_CARS_OUTPUT = "Enter the names of the cars (comma-separated):"
    private const val PLAY_ROUND_OUTPUT = "How many rounds will be played?"
    private const val RACE_RESULTS = "Race Results"
    private const val WINNERS = "Winners : "
    private const val DISTANCE = "-"

    fun printNamesOfCars() {
        println(ENTER_THE_NAMES_OF_CARS_OUTPUT)
    }

    fun printPlayerRound() {
        println(PLAY_ROUND_OUTPUT)
    }

    fun printPlayerCarState(playerCar: PlayerCar) {
        print(playerCar.name + " : ")
        repeat(playerCar.distance) { print(DISTANCE) }
        println()
    }

    fun printBlankLine() {
        println()
    }

    fun printRaceResults() {
        printBlankLine()
        println(RACE_RESULTS)
    }

    fun printWinners(winners: List<PlayerCar>) {
        printBlankLine()
        print(WINNERS)
        println(winners.joinToString(", ") { it.name })
    }


}