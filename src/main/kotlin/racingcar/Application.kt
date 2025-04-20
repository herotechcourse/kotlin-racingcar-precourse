package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the name of the cars (comma-separated):")
    val carInput = Console.readLine() ?: ""
    println("How many rounds will be played?")
    val roundInput = Console.readLine() ?: ""

    val race = Race(carInput, roundInput.toInt())
    println()

    race.playRound()
}