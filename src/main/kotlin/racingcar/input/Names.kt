package racingcar.input

import racingcar.input.Utils.throwErrorIf

object Names {

  fun getInput(input: String): List<String> {
    val carList = parse(input)
    validate(carList)
    return carList
  }

  private fun parse(input: String): List<String> {
    return input.split(",").map { it.trim().lowercase() }
  }

  private fun validate(carList: List<String>) {
    // Assumes carList is already trimmed and lowercased parseNames
    throwErrorIf(
        carList.size != carList.map { it }.toSet().size,
        "Names.validate(): found duplicate name. Different car names required.")
    throwErrorIf(
        carList.size > 10,
        "Names.validate(): limit was added to number of car names to avoid system overload, please input less than 10 car names")
    throwErrorIf(
        carList.size < 2,
        "Names.validate(): no commas found in input, therefore one car name was recognized. Please enter at least two car names, separated by commas.")
    throwErrorIf(
        carList.any { !it.matches(Regex("^[a-z0-9]{1,5}$")) },
        "Names.validate(): invalid characters or length in car names found at positions ${
        carList.mapIndexedNotNull { index, name -> if (!name.matches(Regex("^[a-zA-Z0-9]{1,5}$"))) index else null }
      } only lowercase letters and numbers allowed.")
  }
}
