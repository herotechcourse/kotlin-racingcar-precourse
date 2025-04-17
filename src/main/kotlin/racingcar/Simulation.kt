package racingcar

object Simulation {

  fun race(cars: List<Car>, totalRounds: Int) {
    println("Race Results:")
    for (round in 1..totalRounds) {
      println("\n--- Round $round")
      runSingleRound(cars)
    }
    declareWinner(cars)
  }

  private fun runSingleRound(cars: List<Car>) {
    for (car in cars) {
      car.attemptMovement()
      println("${car.name}: ${car.progressBar()}")
    }
  }

  private fun declareWinner(cars: List<Car>){
    val longestRun = cars.maxOf { it.position } // TODO: if max is 0, should i return an error or something else?
    val winner = cars.filter { it.position == longestRun }
    val winnerNames = winner.joinToString(", ") { it.name }
    println("\nWinner${if (winner.size > 1) "s" else ""}: $winnerNames")
  }
}
