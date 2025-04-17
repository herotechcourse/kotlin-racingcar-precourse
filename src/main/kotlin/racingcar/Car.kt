package racingcar

import racingcar.Utils.getRandomNumber

data class Car(val name: String, var currLevel: Int = 0) {
  private fun move() {
    this.currLevel++
  }

  fun getProgress(): String {
    return "-".repeat(currLevel)
  }

  fun tryMove() {
    if (getRandomNumber() >= 4) move()
  }

}
