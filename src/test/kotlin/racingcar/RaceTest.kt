package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Race

class RaceTest {

    @Test
    fun `race creates cars from names`() {
        val race = Race(listOf("a", "b", "c"))
        val names = race.getCars().map { it.name }
        assertThat(names).containsExactly("a", "b", "c")
    }


}