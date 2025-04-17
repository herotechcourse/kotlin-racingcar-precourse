package racingcar

import camp.nextstep.edu.missionutils.Console

// TODO: check if switching to a class could help with better unit testing
object InputHandler {

  fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val carList = Console.readLine().split(",").map { it.trim() }
    return carList // TODO: validate names with required format and other edgecases
  }

  fun getTotalRounds(): Int {
    println("How many rounds will be played?")
    val totalRounds = Console.readLine().toIntOrNull()
    if (totalRounds == null || totalRounds <= 0)
        throw IllegalArgumentException(
            "Input failed at getTotalRounds(): '$totalRounds' is not a valid round count.")
    return totalRounds
  }
}
