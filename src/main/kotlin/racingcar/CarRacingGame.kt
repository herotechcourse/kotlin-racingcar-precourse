package racingcar

class CarRacingGame {
    fun start() {
      println("Starting game setup...")
    }
  }
  
  private fun readCarNames(): List<String> {
    println("Enter car names (comma-separated, max 5 characters each):")
    val input = readLine() ?: throw IllegalArgumentException("Input cannot be null")
    val names = input.split(",").map { it.trim() }
    if (names.isEmpty() || names.any { it.isEmpty() || it.length > 5 }) {
      throw IllegalArgumentException("Each car name must be 1–5 characters long.")
    }
    return names
  }

  fun start() {
    val carNames = readCarNames()
    val rounds = readRounds()
    println("Number of rounds: $rounds")
  }

  private fun readRounds(): Int {
    println("Enter number of rounds:")
    val input = readLine() ?: throw IllegalArgumentException("Input cannot be null")
    val rounds = input.toIntOrNull() ?: throw IllegalArgumentException("Must enter a valid number.")
    if (rounds <= 0) throw IllegalArgumentException("Rounds must be greater than zero.")
    return rounds
  }