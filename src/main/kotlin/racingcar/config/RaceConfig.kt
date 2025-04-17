package racingcar.config

import racingcar.application.RacingGame
import racingcar.domain.*
import racingcar.formatter.RaceProgressFormatter
import racingcar.formatter.WinnerFormatter
import racingcar.parser.CarNameParser
import racingcar.parser.RoundParser
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView

class RaceConfig {
    fun raceRunner(): RacingGame {
        val inputView = ConsoleInputView()
        val outputView = ConsoleOutputView()
        val carNameParser = CarNameParser()
        val roundParser = RoundParser()
        val numberGenerator = RandomNumberGenerator()
        val racePolicy = DefaultRacePolicy()
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
