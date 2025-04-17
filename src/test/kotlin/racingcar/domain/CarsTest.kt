package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CarsTest {

    @Nested
    inner class `Success` {

        @Test
        fun `create cars from list of CarNames`() {
            val names = listOf("pobi", "woni", "jun").map { CarName.from(it) }
            val cars = Cars.of(names)

            assertThat(cars.names()).containsExactly("pobi", "woni", "jun")
            assertThat(cars.positions()).containsExactly(0, 0, 0)
        }

        @Test
        fun `move cars conditionally`() {
            val names = listOf("pobi", "woni", "jun").map { CarName.from(it) }
            val cars = Cars.of(names)

            cars.moveIfSatisfied { it.name() == "woni" }

            assertThat(cars.names()).containsExactly("pobi", "woni", "jun")
            assertThat(cars.positions()).containsExactly(0, 1, 0)
        }

        @Test
        fun `return winners with max position`() {
            val names = listOf("a", "b", "c").map { CarName.from(it) }
            val cars = Cars.of(names)

            cars.moveIfSatisfied { it.name() == "b" || it.name() == "c" }
            cars.moveIfSatisfied { it.name() == "c" }

            val winners = cars.winners()

            assertThat(winners.map { it.name() }).containsExactly("c")
        }

        @Test
        fun `multiple cars can win if they have the same position`() {
            val names = listOf("a", "b").map { CarName.from(it) }
            val cars = Cars.of(names)

            cars.moveIfSatisfied { true }
            val winners = cars.winners()

            assertThat(winners.map { it.name() }).containsExactly("a", "b")
        }

        @Test
        fun `roundResult should return a deep copied state of cars`() {
            val names = listOf("a", "b", "c").map { CarName.from(it) }
            val cars = Cars.of(names)

            cars.moveIfSatisfied { it.name() == "a" || it.name() == "b" }

            val roundResult = cars.roundResult()

            assertThat(cars.positions()).containsExactly(1, 1, 0)
            assertThat(roundResult.positions()).containsExactly(1, 1, 0)

            cars.moveIfSatisfied { it.name() == "a" }

            assertThat(cars.positions()).containsExactly(2, 1, 0)
            assertThat(roundResult.positions()).containsExactly(1, 1, 0)
        }

    }

    @Nested
    inner class `Failure` {

        @Test
        fun `winners returns empty list when there are no cars`() {
            val cars = Cars.of(emptyList())
            val winners = cars.winners()

            assertThat(winners).isEmpty()
        }
    }
}
