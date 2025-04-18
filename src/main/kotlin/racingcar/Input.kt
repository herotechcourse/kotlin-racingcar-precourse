package racingcar

import camp.nextstep.edu.missionutils.Console

object Input {
    fun readCarNamesToRound(): Settings {
        Output.printCarNameInputMessage()
        val carNames = readNamesOfTheCars()

        Output.printRoundInputMessage()
        val round = readNumberOfRounds()

        return Settings(carNames, round)
    }

    fun readNamesOfTheCars(): List<String> {
        val input = Console.readLine()
        val regex = Regex("^[^\\s]{1,5}$")
        val carNames = input.split(",")

        require(carNames.all { it.matches(regex) })
        require(carNames.size == carNames.toSet().size)

        return carNames
    }

    fun readNumberOfRounds(): Int {
        val input = Console.readLine()
        val regex = Regex("^[1-9][0-9]*$")

        require(input.matches(regex))

        return input.toInt()
    }
}