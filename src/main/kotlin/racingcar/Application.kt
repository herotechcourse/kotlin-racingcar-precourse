package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNamesUserInput = Console.readLine()
    val numberOfRoundUserInput = Console.readLine()

    checkCarNameValidation(carNamesUserInput)
    checkRoundValidation(numberOfRoundUserInput)

}