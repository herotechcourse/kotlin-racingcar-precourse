package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNamesUserInput = Console.readLine()
    val numberOfRoundUserInput = Console.readLine()

    checkCarNameValidation(carNamesUserInput)
    checkRoundValidation(numberOfRoundUserInput)

    val carNameList: List<String> = carNamesUserInput.split(",")
    val roundNumber: Int = numberOfRoundUserInput.toInt()
    val progressOfGame:HashMap<String, Int> = initializeGame(carNameList)

    repeat(roundNumber) {
        processGame(progressOfGame)
    }
}