package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Please enter the name of the cars (coma-separated):")
    val carNamesInput = Console.readLine().trim()

    validateCarNames(carNamesInput)

    println("How many rounds will be played ? ")
    val roundsInput = Console.readLine().trim()

    val rounds = validateRounds(roundsInput)

    val carNames = carNamesInput
        .split(",")
        .map{it.trim()}

    val game = RacingGame(carNames)

    println("\nRace Results")

    repeat(rounds) { roundIndex ->
        game.playRound()

        game.cars.forEach { car ->
            val progressBar = "-".repeat(car.position)
            println("${car.name} : $progressBar")
        }
        println()
    }
    val winners = game.getWinners()
    println("Winners : ${winners.joinToString(", ")}")
}
