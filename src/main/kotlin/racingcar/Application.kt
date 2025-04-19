package racingcar

import racingcar.controller.GameController

fun main() {
    try {
        val gameController = GameController()
        gameController.init()
        gameController.start()
        gameController.announceWinners()
    } catch (e: IllegalArgumentException) {
        println("Wrong Arguments: ${e.message}");
        throw e
    } catch (e: Exception) {
        println("Error: ${e.message}");
        throw e
    }
}