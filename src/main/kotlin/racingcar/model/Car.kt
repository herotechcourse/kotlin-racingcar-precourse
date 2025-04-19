package racingcar.model

import racingcar.utils.Utils.getRandomNumberFromZeroToNine


data class Car(val name: String, var currLevel: Int = 0) {
  private fun move() {
    this.currLevel++
  }

  fun getProgress(): String {
    return "-".repeat(currLevel)
  }

  fun tryMove() {
    if (getRandomNumberFromZeroToNine() >= 4) move()
  }

}
