package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerJudgeTest {
    @Test
    fun `findWinners returns single winner when one car has max position`() {
        val cars = listOf(
            Car("pobi", 5),
            Car("woni", 3),
            Car("jun", 4)
        )
        val winners = findWinners(cars)
        assertThat(winners).isEqualTo(listOf("pobi"))
    }

    @Test
    fun `findWinners returns multiple winners when multiple cars have max position`() {
        val cars = listOf(
            Car("pobi", 5),
            Car("woni", 5),
            Car("jun", 4)
        )
        val winners = findWinners(cars)
        assertThat(winners).isEqualTo(listOf("pobi", "woni"))
    }

    @Test
    fun `findWinners returns empty list when no cars are present`() {
        val cars = emptyList<Car>()
        val winners = findWinners(cars)
        assertThat(winners).isEqualTo(emptyList<String>())
    }
}
