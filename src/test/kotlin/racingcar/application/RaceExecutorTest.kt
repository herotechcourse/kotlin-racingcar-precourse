package racingcar.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.domain.*

class RaceExecutorTest {

    @Nested
    inner class `Success Case` {

        @Test
        fun `car moves if policy allows`() {
            val generator = StubNumberGenerator(0)
            val policy = StubRacePolicy(true)
            val cars = Cars.of(names)
            val executor = RaceExecutor(generator, cars, 1, policy)

            val roundResults = executor.execute()

            assertThat(roundResults[0].positions()).containsExactly(1, 1, 1)
        }

        @Test
        fun `car does not move if policy disallows`() {
            val generator = StubNumberGenerator(100)
            val policy = StubRacePolicy(false)
            val cars = Cars.of(names)
            val executor = RaceExecutor(generator, cars, 1, policy)

            val roundResults = executor.execute()

            assertThat(roundResults[0].positions()).containsExactly(0, 0, 0)
        }

        @Test
        fun `car moves multiple rounds if policy allows`() {
            val generator = StubNumberGenerator(0)
            val policy = StubRacePolicy(true)
            val cars = Cars.of(names)
            val executor = RaceExecutor(generator, cars, 3, policy)

            val roundResults = executor.execute()

            assertThat(roundResults[0].positions()).containsExactly(1, 1, 1)
            assertThat(roundResults[1].positions()).containsExactly(2, 2, 2)
            assertThat(roundResults[2].positions()).containsExactly(3, 3, 3)
        }
    }

    private class StubNumberGenerator(private val fixedNumber: Int) : NumberGenerator {
        override fun generate(): Int = fixedNumber
    }

    private class StubRacePolicy(private val shouldMove: Boolean) : RacePolicy {
        override fun canMove(car: Car, number: Int): Boolean = shouldMove
    }

    private val names = listOf("pobi", "woni", "jun").map { CarName.from(it) }
}


