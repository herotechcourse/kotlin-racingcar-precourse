package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.RacingGame
import racingcar.model.Car

  fun main() {
    println("Enter the names of the cars (comma-separated):")
    val inputNames = Console.readLine()
    val carNames = inputNames.split(",").map { it.trim() }

    val cars = try {
      carNames.map { Car(it) }
    } catch (e: IllegalArgumentException) {
      throw IllegalArgumentException("Each car name must be 1 to 5 characters.")
    }

    println("How many rounds will be played?")
    val roundInput = Console.readLine()
    val rounds = roundInput.toIntOrNull()
      ?: throw IllegalArgumentException("Number of rounds must be a valid integer.")

    val game = RacingGame(cars, rounds)
    game.startRace()
  }
