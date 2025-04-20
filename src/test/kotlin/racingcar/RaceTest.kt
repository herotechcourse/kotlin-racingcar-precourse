package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `all cars move based on random values`() {
        val cars = listOf(Car("a"), Car("b"))
        val race = Race(cars, 1)

        assertRandomNumberInRangeTest(
            {
                race.start()
                assertThat(cars[0].position).isEqualTo(1) // 4 or more
                assertThat(cars[1].position).isEqualTo(0) // less than 4
            },
            5, 2 // First for "a", second for "b"
        )
    }

    @Test
    fun `winner is car with the highest position`() {
        val cars = listOf(Car("a"), Car("b"), Car("c"))
        val race = Race(cars, 1)

        assertRandomNumberInRangeTest(
            {
                race.start()
                val max = cars.maxOf { it.position }
                val winners = cars.filter { it.position == max }.map { it.name }
                assertThat(winners).containsExactly("a", "c")
            },
            4, 3, 4 // a: move, b: stop, c: move
        )
    }
}
