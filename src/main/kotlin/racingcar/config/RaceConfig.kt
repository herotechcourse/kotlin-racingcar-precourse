package racingcar.config

import racingcar.application.RacingGame
import racingcar.domain.*
import racingcar.formatter.RaceProgressFormatter
import racingcar.formatter.WinnerFormatter
import racingcar.parser.CarNameParser
import racingcar.parser.RoundParser
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceConfig {
    fun raceRunner(): RacingGame {
        val inputView = InputView()
        val outputView = OutputView()
        val carNameParser = CarNameParser()
        val roundParser = RoundParser()
        val numberGenerator = RandomNumberGenerator()
        val racePolicy = RacePolicy()
        val progressFormatter = RaceProgressFormatter()
        val winnerFormatter = WinnerFormatter()

        return RacingGame(
            inputView,
            outputView,
            carNameParser,
            roundParser,
            numberGenerator,
            racePolicy,
            progressFormatter,
            winnerFormatter
        )
    }
}
