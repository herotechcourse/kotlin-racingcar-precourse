package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun `returns winners after racing`() {
        val cars = Cars(listOf("pobi", "woni", "jun"))
        repeat(3) { cars.raceOnce() }

        val winners = cars.getWinners()
        assertThat(winners).isNotEmpty()
    }

    @Test
    fun `throws exception when car names are duplicated`() {
        val duplicatedNames = listOf("pobi", "pobi")
        assertThrows<IllegalArgumentException> {
            Cars(duplicatedNames)
        }
    }
}