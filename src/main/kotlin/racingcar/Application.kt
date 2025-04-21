package racingcar

import racingcar.frontend.Frontend

/**
 * Application entry point.
 */
fun main() {
    // Read raw user input
    val rawCarNames = Frontend.readCarNames()

    val rawRounds = Frontend.readRounds()

}
