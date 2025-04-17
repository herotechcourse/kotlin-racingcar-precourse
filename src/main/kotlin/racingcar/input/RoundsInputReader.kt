package racingcar.input

import camp.nextstep.edu.missionutils.Console

object RoundsInputReader {
    fun read(): String {
        println("How many rounds will be played?")
        return Console.readLine()
    }
}
