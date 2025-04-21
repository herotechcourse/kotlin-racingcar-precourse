package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `all cars move forward`() {
        val names = listOf("pobi", "woni", "jun")
        val cars = Cars(names, object : IntGeneratorStrategy {
            override fun getIntValue(): Int = 9
        })

        cars.requestCarMove()

        val positions = cars.getCars().map { it.position }

        assertThat(positions).allMatch { it == 1 }
    }

    @Test
    fun `returns the furthest distance any car has moved`() {
        val names = listOf("pobi", "woni")
        val cars = Cars(names, object : IntGeneratorStrategy {
            override fun getIntValue(): Int = 9
        })

        cars.requestCarMove()

        assertThat(cars.longestPosition).isEqualTo(1)
    }
}
