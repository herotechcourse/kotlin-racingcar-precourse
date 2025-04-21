package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

private const val MAX_NAME_LENGTH = 5
private const val MOVE_TRIGGER_VALUE = 4

class Car(val name: String, private var position: Int) {

  constructor(name: String) : this(name, 0)

  init {
    require(name.length <= MAX_NAME_LENGTH && name.isNotBlank()) {
      throw IllegalArgumentException("Each car name cannot exceed $MAX_NAME_LENGTH characters.")
    }
  }

  fun move() {
    if(Randoms.pickNumberInRange(0, 9) >= MOVE_TRIGGER_VALUE) {
      position++
    }
  }

  fun getPosition() : Int = position

  fun display(): String = "$name : ${"-".repeat(position)}"
}