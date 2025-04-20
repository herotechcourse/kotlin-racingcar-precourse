package racingcar.service

import racingcar.view.InputCarNames
import racingcar.view.InputRoundCount

class InputService {
    fun readCarNames(): List<String> {
        return InputCarNames.invoke()
    }

    fun readRoundCount(): Int {
        return InputRoundCount.invoke()
    }
}