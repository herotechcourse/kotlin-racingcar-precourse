package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.constant.DisplayMessage.INPUT_CAR_NAMES
import racingcar.constant.DisplayMessage.INPUT_TOTAL_ROUNDS

object InputView {

    fun getCarNames(): List<String> {
        println(INPUT_CAR_NAMES)
        return Console.readLine()
            .split(",")
            .map { it.trim() }
    }

    fun getTotalRound(): String {
        println(INPUT_TOTAL_ROUNDS)
        return Console.readLine()
    }
}