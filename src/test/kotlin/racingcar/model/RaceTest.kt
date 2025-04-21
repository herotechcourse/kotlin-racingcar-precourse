package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `race should find single winner`() {
        val cars = listOf(
            Car("pobi").apply { repeat(3) { move(4) } },
            Car("woni").apply { repeat(2) { move(4) } }
        )
        val race = Race(cars)
        val winners = race.findWinners()
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `race should find multiple winners`() {
        val cars = listOf(
            Car("pobi").apply { repeat(3) { move(4) } },
            Car("woni").apply { repeat(3) { move(4) } },
            Car("jun").apply { repeat(2) { move(4) } }
        )
        val race = Race(cars)
        val winners = race.findWinners()
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni")
    }

    @Test
    fun `race should play correct number of rounds`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val race = Race(cars)
        
        assertRandomNumberInRangeTest(
            {
                val result = race.play(2)
                assertThat(result).hasSize(2)
                assertThat(result[0]).hasSize(2)
                assertThat(result[1]).hasSize(2)
            },
            4, 3, 5, 2
        )
    }
} 