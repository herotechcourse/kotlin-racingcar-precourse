package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput: String = Console.readLine()
    validateCarsInput(input = carNamesInput)

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    validateRoundsInput(input = roundsInput)

}
