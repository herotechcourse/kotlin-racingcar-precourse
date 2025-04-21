package racingcar.util

open class RaceUtil {
    fun readRounds(inputProvider: () -> String?, validator: (rounds: Int?) -> Result<Int>): Int {
        println("How many rounds will be played?")
        val rounds = inputProvider()?.toIntOrNull()
        return validator(rounds).getOrElse { throw it }
    }
}

