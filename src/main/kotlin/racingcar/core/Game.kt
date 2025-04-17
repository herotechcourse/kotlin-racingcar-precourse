package racingcar.core

import racingcar.utils.Printer.printRound
import racingcar.model.Car

class Game(val cars: MutableList<Car>, val rounds: Int) {

  fun startRace() {
    println("Race Results:")
    repeat(rounds) {
      cars.forEach(Car::tryMove)
      printRoundResult()
    }
  }

  private fun printRoundResult() {
    printRound(cars)
  }

  fun getWinners(): List<Car> {
    val maxLevel = cars.maxOf { it.currLevel }
    return cars.filter { it.currLevel == maxLevel }
  }


}
