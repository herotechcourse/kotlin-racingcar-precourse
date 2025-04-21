package racingcar.controller

import racingcar.domain.Race
import racingcar.view.InputManager

class App {
    fun run() {
        try {
            val carNames = InputManager.readCarNames()
            val tries = InputManager.readTries()
            val race = Race(carNames)
            race.run(tries)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            throw e
        } catch (e: Exception) {
            println("[ERROR] An Unexpected error occurred: ${e.message}")
            throw e
        }
    }
}