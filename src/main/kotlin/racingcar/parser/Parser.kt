package racingcar.parser

import racingcar.utils.ErrorMessages
import racingcar.model.Car

object Parser {
  fun parseCars(input: String): MutableList<Car> {
    return input.split(",")
      .map { it.trim() }
      .onEach {
        require(it.isNotEmpty()) { ErrorMessages.ERROR_EMPTY_CAR_NAME }
        require(it.length <= 5) { ErrorMessages.ERROR_LONG_CAR_NAME }
      }
      .map { Car(it) }
      .toMutableList()
  }
}
