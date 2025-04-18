package racingcar.frontend

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getCarNames(): String {
        return Console.readLine()
    }

    fun getRoundCount(): String {
        return Console.readLine()
    }
}