package racingcar

fun main() {
    // TODO: Implement the program
}


object InputController {
    fun readNamesOfCars(): List<String>? {
        return readlnOrNull()?.split(",")
    }

    fun readRounds(): Int? {
        return readlnOrNull()?.toInt()
    }
}


object OutputController {
    private const val ENTER_THE_NAMES_OF_CARS_OUTPUT = "Enter the names of the cars (comma-separated):"
    private const val PLAY_ROUND_OUTPUT = "How many rounds will be played?"
    private const val RACE_RESULTS = "Race Results"
    private const val WINNERS = "Winners"

    fun printNamesOfCars() {
        println(ENTER_THE_NAMES_OF_CARS_OUTPUT)
    }

    fun printPlayerRound() {
        println(PLAY_ROUND_OUTPUT)
    }
}