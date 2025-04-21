package racingcar

import racingcar.frontend.Frontend
import racingcar.validation.CarNameValidator
import racingcar.validation.RoundCountValidator

/**
 * Application entry point.
 */
fun main() {
    // Read raw user input
    val rawCarNames = Frontend.readCarNames()
    val carNames = CarNameValidator.validate(rawCarNames)

    val rawRounds = Frontend.readRounds()
    val rounds = RoundCountValidator.validate(rawRounds)

}
