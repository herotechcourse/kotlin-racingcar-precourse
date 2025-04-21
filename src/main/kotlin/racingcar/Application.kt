package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
  val carNames = readCarNames()
  val tryCount = readTryCount()
  val cars = carNames.map { Car(it) }

  println("\nRace Results")
  repeat(tryCount) {
    cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
    cars.forEach { println("${it.name} : ${it.positionString()}") }
    println()
  }

  val maxPosition = cars.maxOf { it.position }
  val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
  println("Winners : $winners")
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

class Car(val name: String) {
  var position: Int = 0
    private set

  fun move(randomNumber: Int) {
    if (randomNumber >= 4) {
      position++
    }
  }

  fun positionString(): String = "-".repeat(position)
}
