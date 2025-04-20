package racingcar.model

import racingcar.utils.Utils.getRandomNumberFromZeroToNine


data class Car(val name: String, var currLevel: Int = 0) {

  companion object {
    const val MOVE_THRESHOLD = 4
  }

  private fun move() {
    this.currLevel++
  }

  fun getProgress(): String {
    return "-".repeat(currLevel)
  }

  fun tryMove() {
    if (getRandomNumberFromZeroToNine() >= MOVE_THRESHOLD) move()
  }

}
