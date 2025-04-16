package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    try {
        val carNamesUserInput = Console.readLine()
        val numberOfRoundUserInput = Console.readLine()

        checkCarNameValidation(carNamesUserInput)
        checkRoundValidation(numberOfRoundUserInput)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}