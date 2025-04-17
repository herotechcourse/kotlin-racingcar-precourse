package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*


class CarTest {

    @Test
    fun `car name must not be empty`() {
        assertThatIllegalArgumentException().isThrownBy { Car("") }.withMessage("Car name must not be empty")
    }

    @Test
    fun `car name length must not be more than 5`() {
        assertThatIllegalArgumentException().isThrownBy { Car("qwerty") }
            .withMessage("Car name must not exceed 5 characters")
    }

    @Test
    fun `car name is valid if non-empty and up to 5 characters`() {
        Car("happy")
    }
}
