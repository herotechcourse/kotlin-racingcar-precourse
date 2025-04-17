package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val carNamesInput = readCarNamesInput()
        println("Raw input: $carNamesInput") // Temporary debug output
    }

    private fun readCarNamesInput(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }
}