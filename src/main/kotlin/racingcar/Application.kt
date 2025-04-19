package racingcar

fun main() {
    try {
        InputHandler.readAndValidateCarNames()
        InputHandler.readAndValidateRounds()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
