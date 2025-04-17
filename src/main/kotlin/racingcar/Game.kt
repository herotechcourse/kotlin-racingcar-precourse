package racingcar

import racingcar.Printer.printRound

class Game(val cars: MutableList<Car>, val rounds: Int) {

  fun startRace() {
    println("Race Results:")
    repeat(rounds) {
      cars.forEach(Car::tryMove)
      printRoundResult()
    }
  }

  private fun printRoundResult() {
    println()
    printRound(cars)
  }

  fun getWinners(): List<Car> {
    val maxLevel = cars.maxOf { it.currLevel }
    return cars.filter { it.currLevel == maxLevel }
  }


}
