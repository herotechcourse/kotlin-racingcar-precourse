package racingcar

import racingcar.domain.Race
import racingcar.domain.Winner
import racingcar.ui.InputView
import racingcar.ui.OutputView

class AppConfig {
    private fun inputView() : InputView {
        return InputView()
    }
    private fun outputView() : OutputView{
        return OutputView()
    }
    private fun winner(): Winner{
        return Winner()
    }
    fun race():Race{
        return Race(
            outputView = outputView(),
            inputView = inputView(),
            winner = winner(),
        )
    }
}