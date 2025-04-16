package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {

  val id: Int = nextId++ // thought could be useful to set an id for every car

  companion object {
    private var nextId: Int = 1
  }

  var position: Int = 0
    private set // decided to keep the position private, to prevent unepected behaviour

  fun attemptMovement(): Int {
    val random = Randoms.pickNumberInRange(0, 9)
    if (random >= 4) {
      position += 1
    }
    return random // added for simple debugging purposes
  }

  fun progressBar(): String = "-".repeat(position)
}
