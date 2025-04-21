package racingcar.model

private const val MAX_NAME_LENGTH = 5

class Car(val name: String, private var position: Int) {
  constructor(name: String) : this(name, 0)

  init {
        require(name.length <= MAX_NAME_LENGTH && name.isNotBlank()) {
            throw IllegalArgumentException("Each car name cannot exceed $MAX_NAME_LENGTH characters.")
        }
    }
}