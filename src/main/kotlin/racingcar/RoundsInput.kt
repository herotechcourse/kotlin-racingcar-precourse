package racingcar

class RoundsInput {
    fun inputRounds(): Int {
        println("Input number of rounds")
        val input = readLine() ?: throw IllegalArgumentException("Input invalid!")
        return input.toInt()
    }
}
