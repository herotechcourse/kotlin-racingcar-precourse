package racingcar.model

data class Car(val name: String, var position: Int = 0) {
  init {
    require(name.isNotBlank()) { "Car name must not be blank." }
    require(name.length <= 5) { "Car name must be at most 5 characters." }
  }

  fun moveForward(randomNumber: Int) {
    if (randomNumber >= 4) {
      position++
    }
  }

  fun progress(): String = "-".repeat(position)
}
