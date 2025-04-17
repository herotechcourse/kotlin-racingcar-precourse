package racingcar.view

import camp.nextstep.edu.missionutils.Console


class InputViewImpl: InputView {
    override fun readCarName(): String {
        return Console.readLine()
    }

    override fun readRounds(): String {
        return Console.readLine()
    }
}