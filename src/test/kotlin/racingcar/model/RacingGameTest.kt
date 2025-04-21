package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.intent.UserIntent
import racingcar.model.RacingState

class RacingGameTest {

    @Test
    fun `should update state correctly after game starts`() {
        val game = RacingGame()
        var state = RacingState()
        state = game.reduce(state, UserIntent.EnterCarNames(listOf("pobi", "crong")))
        state = game.reduce(state, UserIntent.EnterRounds(3))
        state = game.reduce(state, UserIntent.StartGame)
        assertThat(state.raceFinished).isTrue
        assertThat(state.currentRound).isEqualTo(3)
        assertThat(state.cars).hasSize(2)
    }
}
