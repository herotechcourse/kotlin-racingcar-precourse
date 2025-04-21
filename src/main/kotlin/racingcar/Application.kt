package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
  val carNames = readCarNames()
  println("Car names: $carNames")
}

fun readCarNames(): List<String> {
  println("Enter the names of the cars (comma-separated):")
  val input = Console.readLine()
  val names = input.split(",").map { it.trim() }

  if (names.any { it.isEmpty() || it.length > 5 }) {
    throw IllegalArgumentException("Car names must be non-empty and at most 5 characters.")
  }

  if (names.distinct().size != names.size) {
    throw IllegalArgumentException("Duplicate car names are not allowed.")
  }

  return names
}
fun readTryCount(): Int {
  println("How many rounds will be played?")
  val input = Console.readLine()
  return input.toIntOrNull()?.takeIf { it > 0 }
    ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
}