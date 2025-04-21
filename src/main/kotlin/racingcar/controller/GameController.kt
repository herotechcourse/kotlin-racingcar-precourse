package racingcar.controller

class GameController(private val cars: List<Car>, private val rounds: Int) {
  fun startRace() {
    repeat(rounds) {
      cars.forEach { it.move() }
      displayRound()
    }
  }

  private fuc displayRound() {
    cars.forEach { println(it.display) }
    println()
  }

  fun getWinners() : List<Car> {
    val max = cars.maxOf { it.getPosition() }
    return cars.filter { it.getPosition() == max }
  }
}