package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {

  var position: Int = 0
    private set

  fun attemptMovement() {
    val random = Randoms.pickNumberInRange(0, 9)
    if (random >= 4) { position++ }
  }

  fun progressBar(): String = "-".repeat(position)
}
