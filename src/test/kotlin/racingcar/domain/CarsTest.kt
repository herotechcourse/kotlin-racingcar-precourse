package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun `returns the winners who moved the farthest`() {
        val cars = Cars(listOf(
            Car("pobi", 3),
            Car("woni", 5),
            Car("jun", 5)
        ))
        val winners = cars.getWinners()
        assertThat(winners).extracting("name")
            .containsExactlyInAnyOrder("woni", "jun")
    }

    @Test
    fun `throws exception when car names are duplicated`() {
        val duplicatedCars = listOf(Car("pobi"), Car("pobi"))
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Cars(duplicatedCars)
        }
    }
}