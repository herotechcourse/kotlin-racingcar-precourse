package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.domain.ErrorMessages.CARS_MINIMUM_COUNT
import racingcar.domain.ErrorMessages.CARS_NO_DUPLICATES

class CarsTest {

    @Test
    fun `init with valid unique names creates Car list in original order`() {
        // given
        val names = listOf("pobi", "woni", "jun")

        // when
        val cars = Cars(names).cars

        // then
        assertThat(cars).hasSize(3)
        assertThat(cars.map { it.name })
            .containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `init with fewer than two names throws IllegalArgumentException`() {
        // given
        val names = listOf("pobi", "Pobi")

        // when

        // then
        assertThatThrownBy { Cars(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CARS_NO_DUPLICATES)
    }

    @Test
    fun `init with duplicate names ignoring case throws IllegalArgumentException`() {
        // given
        val names = listOf("pobi")

        // when

        // then
        assertThatThrownBy { Cars(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(CARS_MINIMUM_COUNT)
    }
}
