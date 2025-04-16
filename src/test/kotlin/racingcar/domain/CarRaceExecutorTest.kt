package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CarRaceExecutorTest {

    private class StubNumberGenerator(private val fixedNumber: Int) : NumberGenerator {
        override fun generate(): Int = fixedNumber
    }

    private val names = listOf("pobi", "woni", "jun").map { CarName.from(it) }

    @Nested
    inner class `Success Case` {

        @Test
        fun `car moves if number is 4 or greater`() {
            val numberGenerator = StubNumberGenerator(5)
            val cars = Cars.of(names)
            val executor = CarRaceExecutor(numberGenerator, cars, 1, RacePolicy())

            val snapshots = executor.runRace()

            assertThat(snapshots).hasSize(1)
            assertThat(snapshots[0].positions()).containsExactly(1, 1, 1)
        }

        @Test
        fun `car does not move if number is less than 4`() {
            val numberGenerator = StubNumberGenerator(3)
            val cars = Cars.of(names)
            val executor = CarRaceExecutor(numberGenerator, cars, 1, RacePolicy())

            val snapshots = executor.runRace()

            assertThat(snapshots).hasSize(1)
            assertThat(snapshots[0].positions()).containsExactly(0, 0, 0)
        }

        @Test
        fun `car moves forward as many rounds as repeated when condition met`() {
            val numberGenerator = StubNumberGenerator(9)
            val cars = Cars.of(names)
            val executor = CarRaceExecutor(numberGenerator, cars, 3, RacePolicy())

            val snapshots = executor.runRace()

            assertThat(snapshots).hasSize(3)
            assertThat(snapshots[0].positions()).containsExactly(1, 1, 1)
            assertThat(snapshots[1].positions()).containsExactly(2, 2, 2)
            assertThat(snapshots[2].positions()).containsExactly(3, 3, 3)
        }
    }
}

