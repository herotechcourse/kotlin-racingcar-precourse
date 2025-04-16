package racingcar.io

class InputHandler {
    fun readInput(prompt: String): String? {
        println(prompt)
        return readlnOrNull()
    }
}