package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
  private const val MAX_NAME_LENGTH = 5

  fun readCarNames() : List<Car> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    if(names.isEmpty() || names.any { it.isBlank() || it.length > MAX_NAME_LENGTH }) {
      throw IllegalArgumentException("Invalid car names.")
    }

    return names.map { Car(it) }
  }

  fun readRounds() : Int {
    println("How many rounds will be played?")
    val input = Console.readLine()

    return input.toIntOrNull()?.takeIf { it > 0 }
      ?: throw IllegalArgumentException("Invalid number of rounds.")
  }
}