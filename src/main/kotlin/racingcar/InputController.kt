package racingcar

import camp.nextstep.edu.missionutils.Console

object InputController {
    fun readNamesOfCars(): List<String> {
        return Console.readLine().split(",")
    }

    fun readRounds(): Int {
        return Console.readLine().toInt()
    }
}