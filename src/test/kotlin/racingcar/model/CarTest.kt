package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Car have a name`() {
        // given
        val alsongCar = Car("alsong", 3)

        // then
        assertThat(alsongCar.name).isEqualTo("alsong")
    }
}
