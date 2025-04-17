package racingcar

import racingcar.controller.GameController

fun main() {
    try {
        val gameController = GameController()
    } catch (e: IllegalArgumentException) {
        println(e.message);
    } catch (e: Exception) {
        println(e.message);
    }
}