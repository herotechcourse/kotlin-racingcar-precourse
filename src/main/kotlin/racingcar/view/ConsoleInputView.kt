package racingcar.view

import camp.nextstep.edu.missionutils.Console

class ConsoleInputView : InputView {
    override fun readCarNames(): String = Console.readLine()
    override fun readNumberOfPlayRound(): String = Console.readLine()
}