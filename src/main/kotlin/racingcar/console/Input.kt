package racingcar.console

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Settings

object Input {
    fun readSettings(): Settings {
        Output.printCarNameInputMessage()
        val carNames = readNamesOfTheCars()

        Output.printRoundInputMessage()
        val round = readNumberOfRounds()

        return Settings(carNames, round)
    }

    /**
     * Reads car names from user input.
     * Allows names with 1 to 5 non-whitespace characters.
     * Ensures all names are unique.
     */
    fun readNamesOfTheCars(): List<String> {
        val input = Console.readLine()
        val regex = Regex("^[^\\s]{1,5}$")
        val carNames = input.split(",")

        require(carNames.all { it.matches(regex) })
        require(carNames.size == carNames.toSet().size)

        return carNames
    }

    /**
     * Reads the number of rounds from user input.
     * Accepts only positive integers (greater than 0).
     */
    fun readNumberOfRounds(): Int {
        val input = Console.readLine()
        val regex = Regex("^[1-9][0-9]*$")

        require(input.matches(regex))

        return input.toInt()
    }
}