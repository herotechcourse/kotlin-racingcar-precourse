package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesUserInput = Console.readLine()
    println("How many rounds will be played?")
    val numberOfRoundUserInput = Console.readLine()

    checkCarNameValidation(carNamesUserInput)
    checkRoundValidation(numberOfRoundUserInput)

    val carNameList: List<String> = carNamesUserInput.split(",")
    val roundNumber: Int = numberOfRoundUserInput.toInt()
    val progressOfGame:LinkedHashMap<String, Int> = initializeGame(carNameList)

    println("Race Results")
    repeat(roundNumber) {
        processGame(progressOfGame)
        displayProgress(progressOfGame)
        println()
    }
    val winnersList = determineWinners(progressOfGame)
    displayWinners(winnersList)
}