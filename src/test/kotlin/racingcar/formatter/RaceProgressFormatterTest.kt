package racingcar.formatter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarName
import racingcar.domain.Cars

class RaceProgressFormatterTest {

    @Test
    fun `format cars into progress strings`() {
        val carNames = listOf("pobi", "woni", "jun").map { CarName.from(it) }
        val cars = Cars.of(carNames)

        cars.moveIf { it.name() != "jun" }

        val formatter = RaceProgressFormatter()
        val result = formatter.format(cars)

        assertThat(result).containsExactly(
            "pobi : -",
            "woni : -",
            "jun : "
        )
    }
}
