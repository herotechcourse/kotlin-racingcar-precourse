package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readNames(): List<String> =
        InputParser.parseNames(Console.readLine())

    fun readRounds(): Int =
        InputParser.parseRounds(Console.readLine())
}
