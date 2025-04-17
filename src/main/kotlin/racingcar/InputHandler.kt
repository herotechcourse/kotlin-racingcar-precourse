package racingcar

import camp.nextstep.edu.missionutils.Console

// TODO: check if switching to a class could help with better unit testing
object InputHandler {

  fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val carList = Console.readLine().split(",").map { it.trim() }
    validateCarNames(carList)
    return carList
  }

  fun getTotalRounds(): Int {
    println("How many rounds will be played?")
    val totalRounds =
        Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("Input failed at getTotalRounds(): found null.")
    validateTotalRounds(totalRounds)
    return totalRounds
  }

  private fun validateCarNames(carList: List<String>) {
    /*
      TODO: could be useful to throw an error if a name is divided by spaces and force user to not use only symbols as names and at least come letters  (regex-check?)
      TODO: could be useful to also put a limit on the number of cars to avoid overloading the system
    */
    throwErrorIf(
        carList.size < 2,
        "Input failed at getCarNames(): more than 1 car is required for the race to start.")
    throwErrorIf(
        carList.any { it.isEmpty() },
        "Input failed at getCarNames(): empty car names found at index ${
          carList.mapIndexedNotNull { index, name -> if (name.isEmpty()) index else null }
          }.")
    throwErrorIf(
        carList.any { it.length > 5 },
        "Input failed at getCarNames(): car names longer than 5 characters found at positions ${ carList.mapIndexedNotNull { index, name -> if (name.length > 5) index else null }}.")
  }

  private fun validateTotalRounds(totalRounds: Int) {
    // TODO: could be useful to put a limit on total rounds to avoid overloading the system - limit
    // could be 100 rounds?
    throwErrorIf(
        totalRounds <= 0,
        "Input failed at getTotalRounds(): '$totalRounds' is not a valid round number.")
  }

  private fun throwErrorIf(error: Boolean, message: String) {
    if (error) throw IllegalArgumentException(message)
  }
}
