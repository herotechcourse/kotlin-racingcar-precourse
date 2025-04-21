package racingcar.input

import camp.nextstep.edu.missionutils.Console
import racingcar.validator.CarNamesValidator
import racingcar.validator.RoundsValidator

object ConsoleInput {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma‑separated): ")
        val names = Console.readLine()
        val carNames = CarNamesValidator().validate(names)
        return carNames
    }

    fun readRounds(): Int {
        println("How many rounds will be played?")
        return RoundsValidator().validate(Console.readLine())
    }
}