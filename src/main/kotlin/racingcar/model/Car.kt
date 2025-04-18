package racingcar.model

class Car(val name: String) {
  var position = 0
    private set

  init {
    require(name.isNotBlank() && name.length <= 5) {
      "Car must have a name, and names cannot exceed 5 characters."
    }
  }

  fun move() {
    position++
  }
}