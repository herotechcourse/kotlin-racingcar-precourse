package racingcar

data class Car(val name: String, var currLevel: Int=0) {
  fun move() {
    this.currLevel++;
  }
  fun getProgress(): String {
    return "-".repeat(currLevel)
  }
}
