package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CarsTest {

    @Nested
    inner class `Success` {

        @Test
        fun `create cars from list of names`() {
            val names = listOf("pobi", "woni", "jun")
            val cars = Cars.of(names)

            assertThat(cars.names()).containsExactly("pobi", "woni", "jun")
            assertThat(cars.positions()).containsExactly(0, 0, 0)
        }

        @Test
        fun `move cars conditionally`() {
            val names = listOf("pobi", "woni", "jun")
            val cars = Cars.of(names)

            cars.moveIf { it.name() == "woni" }

            assertThat(cars.names()).containsExactly("pobi", "woni", "jun")
            assertThat(cars.positions()).containsExactly(0, 1, 0)
        }

        @Test
        fun `return winners with max position`() {
            val names = listOf("a", "b", "c")
            val cars = Cars.of(names)

            cars.moveIf { it.name() == "b" || it.name() == "c" }
            cars.moveIf { it.name() == "c" }

            val winners = cars.winners()

            assertThat(winners.map { it.name() }).containsExactly("c")
        }

        @Test
        fun `multiple cars can win if they have the same position`() {
            val names = listOf("a", "b")
            val cars = Cars.of(names)

            cars.moveIf { true }
            val winners = cars.winners()

            assertThat(winners.map { it.name() }).containsExactly("a", "b")
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
