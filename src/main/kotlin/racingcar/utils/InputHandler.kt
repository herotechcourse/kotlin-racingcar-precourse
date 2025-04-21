package racingcar.utils

import camp.nextstep.edu.missionutils.Console

object InputHandler {

  fun readCarNames(): String {
    println("Enter car names (comma-separated): ")
    return Console.readLine()
  }

  fun readRoundCount(): Int {
    println("How many rounds will be played?")
    val rounds = Console.readLine().toIntOrNull()
    require(rounds != null && rounds > 0) { ErrorMessages.ERROR_INVALID_ROUNDS }
    return rounds
  }
}
