

class Application {
    companion object {
      @JvmStatic
      fun main(args: Array<String>) {
        CarRacingGame().start()
      }
    }
  }
  
  class CarRacingGame {
    fun start() {
      val cars = readCarNames()
      val rounds = readRounds()
      repeat(rounds) {
        println("\nRound ${it + 1}:")
        cars.forEach { it.moveIfPossible() }
        printRaceProgress(cars)
      }
      announceWinners(cars)
    }
  
    private fun readCarNames(): List<Car> {
      println("Enter car names (comma-separated, max 5 characters each):")
      val input = readLine() ?: throw IllegalArgumentException("Input cannot be null")
      val names = input.split(",").map { it.trim() }
      if (names.isEmpty() || names.any { it.isEmpty() || it.length > 5 })
        throw IllegalArgumentException("Each car name must be 1–5 characters long.")
      return names.map { Car(it) }
    }
  
    private fun readRounds(): Int {
      println("Enter number of rounds:")
      val input = readLine() ?: throw IllegalArgumentException("Input cannot be null")
      val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Must enter a valid number.")
      if (rounds <= 0) throw IllegalArgumentException("Rounds must be greater than zero.")
      return rounds
    }
  
    private fun printRaceProgress(cars: List<Car>) {
      cars.forEach {
        println("${it.name}: ${"-".repeat(it.position)}")
      }
    }
  
    private fun announceWinners(cars: List<Car>) {
      val max = cars.maxOf { it.position }
      val winners = cars.filter { it.position == max }.map { it.name }
      println("\nWinner${if (winners.size > 1) "s" else ""}: ${winners.joinToString(", ")}")
    }
  }
  
  class Car(val name: String) {
    var position = 0
  
    fun moveIfPossible() {
      if ((0..9).random() >= 4) position++
    }
  }
  
