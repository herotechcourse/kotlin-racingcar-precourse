package racingcar

import camp.nextstep.edu.missionutils.Console

object Input {
    fun readNamesOfTheCars(): List<String> {
        val input = Console.readLine()
        val regex = Regex("^[^\\s]{1,5}$")
        val carNames = input.split(",")

        require(carNames.all { it.matches(regex) })
        require(carNames.size == carNames.toSet().size)

        return carNames
    }

    fun readNumberOfRounds(): Int {
        return Console.readLine().toInt()
    }
}