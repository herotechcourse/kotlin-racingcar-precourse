package racingcar

fun main() {
    try {
        val rawCarNames = InputHandler.readCarNames()
        InputHandler.validateCarNames(rawCarNames)
        val rawRounds = InputHandler.readRounds()
        InputHandler.validateRounds(rawRounds)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
