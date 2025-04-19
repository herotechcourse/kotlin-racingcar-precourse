package racingcar

import racingcar.controller.GameController

/**
 * Racing Car Game
 * This program simulates a car racing game where cars move forward based on random chances.
 **/
fun main() {
    try {
        val gameController = GameController()
        gameController.start()
        gameController.announceWinners()
    } catch (e: IllegalArgumentException) {
        println("Wrong Arguments: ${e.message}")
        throw e // Throw again the Exception for testing purposes, otherwise use System.exit()
    } catch (e: Exception) {
        println("Error: ${e.message}")
        throw e // Throw again the Exception for testing purposes, otherwise use System.exit()
    }
}