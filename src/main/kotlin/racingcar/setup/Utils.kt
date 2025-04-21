package racingcar.setup

object Utils {
  fun throwErrorIf(error: Boolean, message: String) {
    if (error) throw IllegalArgumentException(message)
  }
}
