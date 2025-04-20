package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
  println("Enter the names of the cars (comma-separated):")
  val names = Console.readLine()
    .split(",")
    .map { it.trim() }
    .also {
      if (it.any { name -> name.isEmpty() || name.length > 5 }) {
        throw IllegalArgumentException("Car names must be non-empty and <= 5 characters")
      }
    }

  println("How many rounds will be played?")
  val rounds = Console.readLine().toIntOrNull()
    ?: throw IllegalArgumentException("Invalid number of rounds")

    val cars = names.map { Car(it) }
    val game = RacingGame(cars)

    println("Race Results")
    repeat(rounds) {
      game.playRound()
      game.printProgress()
    }
    game.printWinners()
}
