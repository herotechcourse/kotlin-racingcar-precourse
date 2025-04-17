package racingcar.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.domain.*
import racingcar.formatter.RaceProgressFormatter
import racingcar.formatter.WinnerFormatter
import racingcar.parser.CarNameParser
import racingcar.parser.RoundParser
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingGameTest {

    @Nested
    inner class SuccessCase {

        @Test
        fun shouldWinAllCarsWhenAllMovable() {
            val outputView = StubOutputView()
            val game = createGame(
                carNames = "car1,car2,car3",
                roundCount = "3",
                policy = NamedRacePolicy(setOf("car1", "car2", "car3")),
                outputView = outputView
            )
            game.run()
            val result = outputView.messages.last()
            assertThat(result).isEqualTo("Winners : car1, car2, car3")
        }

        @Test
        fun shouldWinTwoCarsWhenOnlyTwoMovable() {
            val outputView = StubOutputView()
            val game = createGame(
                carNames = "car1,car2,car3",
                roundCount = "3",
                policy = NamedRacePolicy(setOf("car1", "car2")),
                outputView = outputView
            )
            game.run()
            val result = outputView.messages.last()
            assertThat(result).isEqualTo("Winners : car1, car2")
        }

        @Test
        fun shouldWinOneCarWhenOnlyOneMovable() {
            val outputView = StubOutputView()
            val game = createGame(
                carNames = "car1,car2,car3",
                roundCount = "3",
                policy = NamedRacePolicy(setOf("car2")),
                outputView = outputView
            )
            game.run()
            val result = outputView.messages.last()
            assertThat(result).isEqualTo("Winners : car2")
        }
    }

    private fun createGame(
        carNames: String,
        roundCount: String,
        policy: RacePolicy,
        outputView: StubOutputView
    ): RacingGame {
        return RacingGame(
            StubInputView(carNames, roundCount),
            outputView,
            CarNameParser(),
            RoundParser(),
            StubNumberGenerator(0),
            policy,
            RaceProgressFormatter(),
            WinnerFormatter()
        )
    }

    private class StubInputView(
        private val carNames: String,
        private val roundCount: String
    ) : InputView {
        override fun readCarNames(): String = carNames
        override fun readNumberOfPlayRound(): String = roundCount
    }

    class StubOutputView : OutputView {
        val messages = mutableListOf<String>()

        override fun printCarNamesPrompt() {}
        override fun printRoundCountPrompt() {}
        override fun printRaceResultPrompt() {}
        override fun printProgress(message: List<String>) {}
        override fun printWinners(message: String) {
            messages.add(message)
        }
    }

    private class StubNumberGenerator(private val fixed: Int) : NumberGenerator {
        override fun generate(): Int = fixed
    }

    private class NamedRacePolicy(private val movableCarNames: Set<String>) : RacePolicy {
        override fun canMove(car: Car, number: Int): Boolean {
            return movableCarNames.contains(car.name())
        }
    }
}
