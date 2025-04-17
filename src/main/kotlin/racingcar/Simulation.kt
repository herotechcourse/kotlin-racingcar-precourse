package racingcar

object Simulation {

  fun race(cars: List<Car>, totalRounds: Int) {
    println("Race Results:")
    for (round in 1..totalRounds) {
      println("\n--- Round $round")
      runSingleRound(cars)
    }
    println("${raceResult(cars)}")
  }

  private fun runSingleRound(cars: List<Car>) {
    for (car in cars) {
      car.attemptMovement()
      println("${car.name}: ${car.progressBar()}")
    }
  }

  private fun raceResult(cars: List<Car>): String {
    val longestRun = cars.maxOf { it.position }
    if (longestRun == 0) {
      return "Probability struck: no car moved and no winner could be declared!"
    } else {
      val winners = cars.filter { it.position == longestRun }
      val winnerNames = winners.joinToString(", ") { it.name }
      return "Winner${if (winners.size > 1) "s" else ""}: $winnerNames"
    }
  }
}
