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

}