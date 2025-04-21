package racingcar

fun main() {
    val application = Application()
    application.run()
}

class Application {
    fun run() {
        val inputHandler = InputHandler()
        val inputs = inputHandler.getInputs()
        Race(inputs).run()
    }
}

