package racingcar.io

import camp.nextstep.edu.missionutils.Console

object InputHandler {
    fun readInput(prompt: String): String {
        println(prompt)
        return Console.readLine()
    }
}