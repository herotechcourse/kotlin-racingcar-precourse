package racingcar.race

import racingcar.player.Car
import racingcar.race.SimulationOutput

object Simulation {

  fun race(cars: List<Car>, totalRounds: Int) {
    SimulationOutput.addPadding()
    SimulationOutput.header()
    start(cars, totalRounds)
    end(cars)
  }

  private fun start(cars: List<Car>, totalRounds: Int) {
    for (round in 1..totalRounds) {
      runSingleRound(cars)
      SimulationOutput.addPadding()
    }
  }

  private fun runSingleRound(cars: List<Car>) {
    for (car in cars) {
      car.attemptMovement()
      SimulationOutput.round("${car.name} : ${car.progressBar()}")
    }
  }

  private fun end(cars: List<Car>) {
    val longestRun = cars.maxOf { it.position }
    val result = if (longestRun == 0) emptyList() else cars.filter { it.position == longestRun }
    SimulationOutput.result(result)
  }
}
