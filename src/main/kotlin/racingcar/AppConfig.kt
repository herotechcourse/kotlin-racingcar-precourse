package racingcar

import racingcar.domain.Race
import racingcar.domain.Winner
import racingcar.ui.InputView
import racingcar.ui.OutputView

class AppConfig {
    private fun inputView() = InputView()
    private fun outputView() = OutputView()
    private fun winner() = Winner()
    fun race() = Race(inputView(), outputView(), winner())
}