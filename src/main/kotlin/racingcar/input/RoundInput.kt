package racingcar.input

object RoundInput {

    fun readRound(): String {
        println("How many rounds will be played?")
        return readln()
    }
}