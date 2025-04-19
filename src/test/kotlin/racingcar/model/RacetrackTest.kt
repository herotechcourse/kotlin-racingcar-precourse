package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.fixture.FakeRandomNumberGenerator

class RacetrackTest {
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `racetrack can generate the random numbers from 0 to 9`(number: Int) {
        // given
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(number)
        val car = Car("a")
        val racetrack = Racetrack(listOf(car), fakeRandomNumberGenerator)

        // when
        val randomNumber = racetrack.generateRandomNumber()

        // then
        assertThat(randomNumber).isIn(0..9)
    }
}
