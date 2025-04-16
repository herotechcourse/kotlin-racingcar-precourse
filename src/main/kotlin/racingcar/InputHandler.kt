package racingcar

import camp.nextstep.edu.missionutils.Console

fun getCarNames(): List<String> {
  println("Enter the names of the cars (comma-separated):")
  val carList = Console.readLine().split(",").map { it.trim() }
  return carList
}

fun getTotalRounds(): Int {
  println("How many rounds will be played?")
  val totalRounds = Console.readLine().toIntOrNull()
  if (totalRounds == null || totalRounds <= 0)
      throw IllegalArgumentException(
          "Input failed at getTotalRounds(): '$totalRounds' is not a valid round count.")
  return totalRounds
}