package racingcar

import camp.nextstep.edu.missionutils.Console

object InputHandler {

  fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val carList = parseCarNames(Console.readLine())
    validateCarNames(carList)
    return carList
  }

  fun getTotalRounds(): Int {
    println("How many rounds will be played?")
    val totalRounds = parseTotalRounds(Console.readLine())
    validateTotalRounds(totalRounds)
    return totalRounds
  }

  fun parseCarNames(input: String): List<String> {
    return input.split(",").map { it.trim().lowercase() }
  }

  fun parseTotalRounds(input: String): Int {
    return input.toIntOrNull()
        ?: throw IllegalArgumentException(
            "Input failed at getTotalRounds(): input was not a number.")
  }

  fun validateCarNames(carList: List<String>) {
    // Assumes carList is already trimmed and lowercased parseCarNames
    throwErrorIf(
        carList.size != carList.map { it }.toSet().size,
        "validateCarNames(): found duplicate name. Different car names required.")
    throwErrorIf(
        carList.size > 10,
        "validateCarNames(): limit was added to number of car names to avoid system overload, please input less than 10 car names")
    throwErrorIf(
        carList.size < 2,
        "validateCarNames(): no commas found in input, therefore one car name was recognized. Please enter at least two car names, separated by commas.")
    throwErrorIf(
        carList.any { !it.matches(Regex("^[a-z0-9]{1,5}$")) },
        "validateCarNames(): invalid characters or length in car names found at positions ${
              carList.mapIndexedNotNull { index, name -> if (!name.matches(Regex("^[a-zA-Z0-9]{1,5}$"))) index else null }
          } only letters and numbers allowed.")
  }

  fun validateTotalRounds(totalRounds: Int) {
    throwErrorIf(
        totalRounds > 10,
        "validateTotalRounds(): total rounds has a limit of 10 to avoid system overload, please choose a smaller number of rounds.")

    throwErrorIf(
        totalRounds <= 0, "validateTotalRounds(): '$totalRounds' is not a valid round number.")
  }

  private fun throwErrorIf(error: Boolean, message: String) {
    if (error) throw IllegalArgumentException(message)
  }
}
