package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0) {
  fun move() {
    if (Randoms.pickNumberInRange(0, 9) >= 4) {
      position++
    }
  }
}

class Game {
  private val cars = mutableListOf<Car>()

  fun start() {
    println("Enter car names (separated by commas):")
    val carInput = Console.readLine()
    val carNames = carInput.split(",").map { it.trim() }
    validateCarNames(carNames)

    println("Enter the number of rounds:")
    val roundInput = Console.readLine().toIntOrNull()
    validateRound(roundInput)
    val round = roundInput!!

    initializeCars(carNames)
    play(round)
    printWinners()
  }

  fun validateCarNames(carNames: List<String>) {
    if (carNames.any { it.isBlank() || it.length > 5 }) {
      throw IllegalArgumentException("Car names cannot be blank and must not exceed 5 characters.")
    }
    if (carNames.distinct().size != carNames.size) {
      throw IllegalArgumentException("Car names must be unique.")
    }
  }

  fun validateRound(round: Int?) {
    if (round == null || round <= 0) {
      throw IllegalArgumentException("Number of rounds must be a valid and positive number.")
    }
  }

  fun initializeCars(carNames: List<String>) {
    carNames.forEach { cars.add(Car(it)) }
  }

  fun play(round: Int) {
    repeat(round) {
      playTurn()
      printRound()
      println()
    }
  }

  private fun playTurn() {
    cars.forEach { it.move() }
  }

  private fun printRound() {
    for (car in cars) {
      var dashes = ""
      for (i in 0 until car.position) {
        dashes += "-"
      }
      println("${car.name} : $dashes")
    }
  }

  private fun printWinners() {
    val winners = getWinners()
    println("Winners : ${winners.joinToString(", ")}")
  }

  fun getWinners(): List<String> {
    val maxPosition = cars.maxOf { it.position }
    return cars.filter { it.position == maxPosition }.map { it.name }
  }
}

fun main() {
  Game().start()
}
