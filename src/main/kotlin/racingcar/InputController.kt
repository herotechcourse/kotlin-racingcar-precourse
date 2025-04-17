package racingcar

import camp.nextstep.edu.missionutils.Console

object InputController {

    fun readNamesOfCars(): List<String> {
        val names = Console.readLine()
            .split(",")
            .map { it.trim() }

        Validator.validateNames(names)
        return names
    }

    fun readRounds(): Int {
        return Console.readLine().toInt()
    }
}