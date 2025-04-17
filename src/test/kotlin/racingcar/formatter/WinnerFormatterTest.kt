package racingcar.formatter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarName
import racingcar.domain.Cars

class WinnerFormatterTest {

    @Test
    fun `should format single winner correctly`() {
        val carNames = listOf("pobi", "woni").map { CarName.from(it) }
        val cars = Cars.of(carNames)
        cars.moveIfSatisfied { it.name() == "pobi" }

        val formatter = WinnerFormatter()
        val result = formatter.format(cars)

        assertThat(result).isEqualTo("Winners : pobi")
    }

    @Test
    fun `should format multiple winners correctly`() {
        val carNames = listOf("pobi", "woni", "jun").map { CarName.from(it) }
        val cars = Cars.of(carNames)
        cars.moveIfSatisfied { it.name() != "jun" }

        val formatter = WinnerFormatter()
        val result = formatter.format(cars)

        assertThat(result).isEqualTo("Winners : pobi, woni")
    }
}
