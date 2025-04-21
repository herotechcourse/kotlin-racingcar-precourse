package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RacingProgressMakerTest {
    @Test
    fun `should create list with size equal to racing rounds`() {
        // given
        val carNames = listOf("jin", "bum", "yeji")
        val racingRounds = 5
        // when
        val result = makeRacingProgressList(carNames, racingRounds)

        // then
        assertEquals(racingRounds, result.size)
    }
}