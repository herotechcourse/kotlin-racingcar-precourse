package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.fixture.FakeRandomNumberGenerator

class RacingGameTest {
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `RacingGame can generate the random numbers from 0 to 9`(number: Int) {
        // given
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(number)
        val car = Car("a")
        val racingGame = RacingGame(listOf(car), fakeRandomNumberGenerator)

        // when
        val randomNumber = racingGame.generateRandomNumber()

        // then
        assertThat(randomNumber).isIn(0..9)
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `RacingGame can move cars if random number is 4 or more`(number: Int) {
        // given
        val car = Car("song")
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(number)
        val racingGame = RacingGame(listOf(car), fakeRandomNumberGenerator)

        // when
        racingGame.moveCar()

        // then
        assertThat(car.position).isEqualTo(1)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `RacingGame cannot move cars if random number is 3 or less`(number: Int) {
        // given
        val car = Car("song")
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(number)
        val racingGame = RacingGame(listOf(car), fakeRandomNumberGenerator)

        // when
        racingGame.moveCar()

        // then
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `RacingGame can decide the winner`() {
        // given
        val carA = Car("A")
        val carB = Car("B")
        val fakeRandomNumberGenerator = FakeRandomNumberGenerator(4)
        val racingGame = RacingGame(listOf(carA, carB), fakeRandomNumberGenerator)

        // when
        carA.move(4)
        carB.move(3)
        val winner = racingGame.decideWinner()

        // then
        assertThat(winner).isEqualTo(listOf(carA))
    }
}
