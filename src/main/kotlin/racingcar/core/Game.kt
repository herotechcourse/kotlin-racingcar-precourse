package racingcar.core

import racingcar.utils.Printer.printRound
import racingcar.model.Car

class Game(private val cars: List<Car>, private val rounds: Int) {

  fun startRace() {
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
