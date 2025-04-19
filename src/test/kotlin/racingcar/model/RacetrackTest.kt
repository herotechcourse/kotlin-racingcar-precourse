package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacetrackTest {
    @Test
    fun `racetrack can generate the random numbers from 0 to 9`() {
        // given
        val car = Car("a")
        val racetrack = Racetrack(listOf(car))

        // when
        val randomNumber = racetrack.generateRandomNumber()

        // then
        assertThat(randomNumber).isIn(0..9)
    }
}
