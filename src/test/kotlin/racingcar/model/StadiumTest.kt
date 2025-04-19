package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StadiumTest {
    @Test
    fun `stadium can generate the random numbers from 0 to 9`() {
        // given
        val car = Car("a")
        val stadium = Stadium(listOf(car))

        // when
        val randomNumber = stadium.generateRandomNumber()

        // then
        assertThat(randomNumber).isIn(0..9)
    }
}
