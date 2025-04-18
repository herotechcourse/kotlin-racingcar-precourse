package racingcar

class RacingGame(private val cars: List<Car>) {
  fun playRound() {
    cars.forEach { it.tryMove() }
  }
}