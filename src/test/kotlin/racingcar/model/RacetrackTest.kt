package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `racetrack can move cars if random number is 4 or more`(number: Int) {
        // given
        val car = Car("song")
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(number)
        val racetrack = Racetrack(listOf(car), fakeRandomNumberGenerator)

        // when
        racetrack.moveCar()

        // then
        assertThat(car.position).isEqualTo(1)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `racetrack cannot move cars if random number is 3 or less`(number: Int) {
        // given
        val car = Car("song")
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(number)
        val racetrack = Racetrack(listOf(car), fakeRandomNumberGenerator)

        // when
        racetrack.moveCar()

        // then
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `racetrack can decide the winner`() {
        // given
        val carA = Car("A")
        val carB = Car("B")
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(4)
        val racetrack = Racetrack(listOf(carA, carB), fakeRandomNumberGenerator)

        // when
        carA.move(4)
        carB.move(3)
        val winner = racetrack.decideWinner()

        // then
        assertThat(winner).isEqualTo(listOf(carA))
    }
}
