package racingcar.model

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.util.Constant.CAR_NAME_EXCEED_ERROR_MESSAGE

class CarTest {
    @Test
    fun `Throw an exception if a car name exceeds the maximum length`() {
        assertThatThrownBy { Car("123456789") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(CAR_NAME_EXCEED_ERROR_MESSAGE)
    }
}