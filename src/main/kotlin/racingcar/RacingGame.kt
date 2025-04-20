package racingcar

class RacingGame(private val cars: List<Car>) {
  fun playRound() {
    cars.forEach { it.tryMove() }
  }

  fun printProgress() {
    cars.forEach {
      println("${it.name} : ${"-".repeat(it.position)}")
    }
    println()
  }

  fun printWinners() {
    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
    println("Winners : $winners")
  }

}