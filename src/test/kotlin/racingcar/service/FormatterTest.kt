package racingcar.service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Car

class FormatterTest {

    @Test
    fun `currentPosition returns correct string for car`() {
        val car = Car("pobi", 3)
        val result = Formatter.currentPosition(car)

        assertThat(result).isEqualTo("pobi : ---")
    }

    @Test
    fun `winners returns correct string for single winner`() {
        val result = Formatter.winners(listOf(Car("pobi", 5)))

        assertThat(result).isEqualTo("Winners : pobi")
    }

    @Test
    fun `winners returns correct string for multiple winners`() {
        val result = Formatter.winners(listOf(Car("pobi", 5), Car("jun", 5)))

        assertThat(result).isEqualTo("Winners : pobi, jun")
    }

}