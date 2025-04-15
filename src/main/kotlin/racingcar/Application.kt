package racingcar

import racingcar.validation.CarNameValidator

fun main() {
    try {
        val carNames = CarNameValidator.getAndValidateCarNames()
        println("Valid car names: $carNames")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}