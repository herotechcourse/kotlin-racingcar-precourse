package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
  val carNames = readCarNames()
  val cars = carNames.map { Car(it) }
  val rounds = readNumberOfRounds()

  println("\nRace Results")
  repeat(rounds) {
    cars.forEach { it.move() }
    cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
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

  if (names.isEmpty() || names.any { it.isEmpty() || it.length > 5 })
    throw IllegalArgumentException("Each car must have a name up to 5 characters.")

  return names
}

fun readNumberOfRounds(): Int {
  println("How many rounds will be played?")
  val input = Console.readLine()

  return input.toIntOrNull()?.takeIf { it > 0 }
    ?: throw IllegalArgumentException("Number of rounds must be a positive integer.")
}

class Car(val name: String) {
  var position = 0
    private set

  fun move() {
    if (Randoms.pickNumberInRange(0, 9) >= 4) position++
  }
}
